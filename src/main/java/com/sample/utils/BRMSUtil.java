package com.sample.utils;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;


public class BRMSUtil {

    private KieContainer kContainer = null;

    public BRMSUtil() {
    	KieServices kServices = KieServices.Factory.get(); 
        kContainer = kServices.newKieContainer(kServices.newReleaseId("org.dits", "proj1", "LATEST")); 
        KieScanner kScanner = kServices.newKieScanner( kContainer );
//        kScanner.start( 10000L );
        kScanner.scanNow();
    }
    
    public StatelessKieSession getStatelessSession() {
        return kContainer.newStatelessKieSession();
    }

    /*
     * KieSession is the new StatefulKnowledgeSession from BRMS 5.3.
     */
    public KieSession getStatefulSession() {
        return kContainer.newKieSession();
    }

}
