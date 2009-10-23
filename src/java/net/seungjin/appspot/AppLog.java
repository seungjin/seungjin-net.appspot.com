/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.seungjin.appspot;

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.util.Date;

import com.google.appengine.api.datastore.Text;

/**
 *
 * @author seungjin
 */
public class AppLog {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private Date date;

    @Persistent
    private Text log;

    public AppLog(String log) {
        this.log = new Text(log);
    }

    public String getlog() {
        return log.getValue();
    }

}
