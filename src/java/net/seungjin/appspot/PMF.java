/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.seungjin.appspot;

/**
 *
 * @author seungjin
 */

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMF() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
}