/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package test.scenegraph.fx3d.picking.perspective;

import org.junit.Before;
import org.junit.BeforeClass;
import test.scenegraph.fx3d.picking.MeshPickingTestBase;
import test.scenegraph.fx3d.utils.PickingTestCase;

/**
 *
 * @author Andrew Glushchenko
 */
public class MeshGroupPerspectivePickingTest extends MeshPickingTestBase {

    @BeforeClass
    public static void setUp() {
        MeshPerspectivePickingTestApp.main(null);
        app = mapp = (MeshPerspectivePickingTestApp) MeshPerspectivePickingTestApp.getInstance();
    }

    @Override
    protected double getCameraRealPositionError() {
        return 940;
    }

    @Before
    @Override
    public void prepare() {
        super.prepare();
        setTranslationMode(PickingTestCase.TranslationMode.GroupTranslation);
    }

    @Override
    protected int getLeftX() {
        return 184;
    }

    @Override
    protected int getTopY() {
        return 184;
    }

    @Override
    protected int getDelta() {
        return 136;
    }

    @Override
    protected int getIterations() {
        return 10;
    }
}