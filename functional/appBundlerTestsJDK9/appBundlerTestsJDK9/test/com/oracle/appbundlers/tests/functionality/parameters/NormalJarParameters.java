/*
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.oracle.appbundlers.tests.functionality.parameters;

import static java.util.stream.Collectors.toSet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import com.oracle.appbundlers.tests.functionality.functionalinterface.AdditionalParams;
import com.oracle.appbundlers.tests.functionality.functionalinterface.BasicParams;
import com.oracle.appbundlers.tests.functionality.functionalinterface.VerifiedOptions;
import com.oracle.appbundlers.utils.AppWrapper;
import com.oracle.appbundlers.utils.SourceFactory;
import com.oracle.appbundlers.utils.Utils;
import com.oracle.tools.packager.RelativeFileSet;
import com.oracle.tools.packager.StandardBundlerParam;
import com.sun.javafx.tools.packager.bundlers.BundleParams;

/**
 * @author Ramesh BG
 *
 */
public class NormalJarParameters extends Parameters {

    public NormalJarParameters(BasicParams basicParams,
            AdditionalParams additionalParams,
            VerifiedOptions verifiedOptions) {
        super(basicParams, additionalParams, verifiedOptions);
    }

    public void initializeDefaultApp() throws IOException {
        setApp(new AppWrapper(Utils.getTempSubDir(WORK_DIRECTORY),
                COM_GREETINGS_APP1_QUALIFIED_CLASS_NAME,
                SourceFactory
                        .get_com_greetings_app_unnamed_module()
                ));
    }

    public NormalJarParameters() {

    }

    public Map<String, Object> getBasicParams() throws Exception {
        Map<String, Object> basicParams = new HashMap<String, Object>();
        basicParams.put(BundleParams.PARAM_APP_RESOURCES,
                new RelativeFileSet(this.app.getJarDir().toFile(),
                        app.getJarFilesList().stream().map(Path::toFile)
                                .collect(toSet())));
        basicParams.put(MAIN_JAR,
                new RelativeFileSet(this.app.getJarDir()
                        .toFile(),
                new HashSet<>(
                        Arrays.asList(this.app.getMainJarFile().toFile()))));
        basicParams.put(CLASSPATH,
                this.app.getJarFilesList().stream().map(Path::getFileName)
                        .map(Path::toString)
                        .collect(Collectors.joining(File.pathSeparator)));
        String mainClass = StandardBundlerParam.MAIN_CLASS
                .fetchFrom(basicParams);
        basicParams.put(APPLICATION_CLASS, mainClass);
        return requireNonNull(getBasicParamsFunctionalInterface(), basicParams);
    }
}
