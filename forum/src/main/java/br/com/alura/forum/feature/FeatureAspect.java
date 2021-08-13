package br.com.alura.forum.feature;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeatureAspect {

    private static final Logger LOG = LoggerFactory.getLogger(FeatureAspect.class);

    @Around("@within(featureAssociation) || @annotation(featureAssociation)")
    public Object checkAspect(ProceedingJoinPoint joinPoint,
                              FeatureAssociation featureAssociation) throws Throwable {
        if(featureAssociation.value().isActive()) {
            return joinPoint.proceed();
        } else {
            LOG.info("Feature " + featureAssociation.value().name() + " is not enabled!");
            return null;
        }
    }
}
