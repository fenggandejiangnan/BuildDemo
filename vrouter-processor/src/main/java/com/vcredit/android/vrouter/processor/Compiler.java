package com.vcredit.android.vrouter.processor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.vcredit.android.vrouter.exception.RouterException;
import com.vcredit.android.vrouter.factory.RuleFactory;
import com.vcredit.android.vrouter.module.BasicConfigurations;
import com.vcredit.android.vrouter.module.Parser;
import com.vcredit.android.vrouter.utils.Constants;
import com.vcredit.android.vrouter.utils.LogUtil;
import com.vcredit.android.vrouter.utils.UtilMgr;
import com.vcredit.android.vrouter.utils.Utils;
import com.vcredit.androud.vrouter.annotation.Route;
import com.vcredit.androud.vrouter.annotation.RouteConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class Compiler extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        LogUtil.debug = true;
        LogUtil.print("zew,annotations:"+annotations.size()+"====pack"+roundEnv.toString());
        try {
            BasicConfigurations config = processRouteConfig(roundEnv);
            processRouteRules(roundEnv, new HashMap<String,List<Parser>>(),config);
            LogUtil.print("zew,schema:"+config.getSchema()+"====pack"+config.getPack());
            return false;
        } catch (RouterException e) {
            e.printStackTrace();
            error(e.getElement(),e.getMessage());
            return true;
        }
    }

    private BasicConfigurations processRouteConfig(RoundEnvironment roundEnv) throws RouterException{
        TypeElement type = null;
        try {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(RouteConfig.class);
            Iterator<? extends Element> iterator = elements.iterator();
            BasicConfigurations configurations = null;
            while (iterator.hasNext()) {
                type = (TypeElement) iterator.next();
                if (configurations != null) {
                    throw new RouterException("The RouteConfig in this module was defined duplicated!",type);
                }
                if (!Utils.isSuperClass(type, Constants.CLASSNAME_APPLICATION)) {
                    throw new RouterException("The class you had annotated by RouteConfig must be a Application",type);
                }
                RouteConfig config = type.getAnnotation(RouteConfig.class);
                configurations = new BasicConfigurations(config.schema(),config.pack());
            }
            return configurations == null ? new BasicConfigurations("","") : configurations;
        } catch (RouterException e) {
            e.printStackTrace();
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RouterException(e.getMessage(),e,type);
        }
    }

    private void processRouteRules(RoundEnvironment roundEnv, Map<String, List<Parser>> map,BasicConfigurations config) throws RouterException{
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Route.class);
        TypeElement type = null;
        try {
            for (Element ele : elements) {
                type = (TypeElement) ele;
                if (!Utils.checkTypeValid(type)) continue;

                Parser parser = Parser.create(type,config);
                parser.parse();

                Route rule = type.getAnnotation(Route.class);
                String packName = Utils.isEmpty(rule.pack())
                        ? Utils.isEmpty(config.getPack())
                        ? "com.lzh.router" : config.getPack() : rule.pack();

                if (!map.containsKey(packName)) {
                    map.put(packName,new ArrayList<Parser>());
                }
                map.get(packName).add(parser);
            }

            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                new RuleFactory(ClassName.get(key,"RouterRuleCreator"),map.get(key)).generateCode();
            }
        } catch (RouterException e) {
            e.printStackTrace();
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RouterException(e.getMessage(),e,type);
        }
    }

    /**
     * compiler output method,when compiler occurs exception.should be notice here.
     *
     * @param element Element of class who has a exception when compiled
     * @param message The message should be noticed to user
     * @param args args to inflate message
     */
    private void error(Element element, String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new HashSet<>();
        set.add(Route.class.getCanonicalName());
        set.add(RouteConfig.class.getCanonicalName());
        return set;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        UtilMgr.getMgr().init(processingEnv);
    }


}
