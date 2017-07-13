package com.vcredit.android.vrouter.module;

import com.lzh.compiler.parceler.annotation.Arg;
import com.squareup.javapoet.ClassName;
import com.vcredit.android.vrouter.exception.RouterException;
import com.vcredit.android.vrouter.utils.Constants;
import com.vcredit.android.vrouter.utils.UtilMgr;
import com.vcredit.android.vrouter.utils.Utils;
import com.vcredit.androud.vrouter.annotation.Route;
import com.vcredit.androud.vrouter.annotation.RouteExecutor;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;

public class Parser {
    private static Map<String,TypeElement> parsed = new HashMap<>();
    private String[] routers;
    private TypeElement type;
    private BasicConfigurations configurations;
    private Map<String,TypeMirror> map = new HashMap<>();
    private ClassName executorClass;

    public static Parser create (TypeElement element,BasicConfigurations configurations) {
        Parser parser = new Parser();
        parser.type = element;
        parser.configurations = configurations;
        parser.executorClass = parser.obtainExecutor();
        return parser;
    }

    private ClassName obtainExecutor() {
        RouteExecutor annotation = type.getAnnotation(RouteExecutor.class);
        if (annotation == null) {
            return ClassName.bestGuess(Constants.CLASSNAME_MAINTHREADEXECUTOR);
        }
        try {
            return ClassName.get(annotation.value());
        } catch (MirroredTypeException mirrored) {
            TypeMirror typeMirror = mirrored.getTypeMirror();
            return ClassName.get((TypeElement) UtilMgr.getMgr().getTypeUtils().asElement(typeMirror));
        }
    }

    public void parse () {
        parseEffectField (type);
        routers = type.getAnnotation(Route.class).value();
        for (int i = 0; i < routers.length; i++) {
            String route = routers[i];
            route = completeRoute(route,configurations.getSchema());
            routers[i] = route;
            checkIsDuplicate(route);
        }
    }


    private String completeRoute(String route, String basicSchema) {
        if (Utils.isEmpty(route)) {
            throw new RouterException("value of annotation RouteRule can not be null!",type);
        }
        URI uri = URI.create(route);
        String scheme = uri.getScheme();
        if (Utils.isEmpty(scheme)) {
            if (Utils.isEmpty(basicSchema)) {
                throw new RouterException("Could not find a basic schema set by RouteConfig to join with the route:" + route,type);
            }
            route = basicSchema + "://" + route;
        }
        return route;
    }

    private void checkIsDuplicate(String route) {


        if (route.endsWith("/")) {
            route = route.substring(0,route.lastIndexOf("/"));
        }

        if (parsed.containsKey(route)) {
            throw new RouterException(String.format("A same scheme was double defined on another class %s", parsed.get(route)),type);
        }
        parsed.put(route,type);
    }

    private void parseEffectField(TypeElement type) {
        List<? extends Element> elements = type.getEnclosedElements();
        for (Element ele : elements) {
            if (ele.getKind() != ElementKind.FIELD) continue;
            // get field annotated by Arg
            if (!Utils.isEffectType((VariableElement) ele)) continue;

            Arg arg = ele.getAnnotation(Arg.class);
            if (arg == null) continue;

            String key = Utils.getKeyFromArg(arg,ele.getSimpleName().toString());
            map.put(key,ele.asType());
        }
    }

    public Map<String, TypeMirror> getMap() {
        return map;
    }

    public String[] getScheme() {
        return routers;
    }

    public TypeElement getType() {
        return type;
    }

    public ClassName getExecutorClass() {
        return executorClass;
    }
}

