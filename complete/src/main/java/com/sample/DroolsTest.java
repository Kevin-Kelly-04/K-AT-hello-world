package com.sample;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

//import com.sample.DroolsTest.Message;
import com.sample.userChoice.Choice;

import Controller.UserFrame;
import Model.UserModel;
import java.awt.Desktop;
import java.net.URI;
/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
    public static UserModel model;
    public static final void main(String[] args) throws Exception {
        model = new UserModel();
        UserFrame frame = new UserFrame(model);


        //System.out.println(model.getGivenAnswers());
    }
}
