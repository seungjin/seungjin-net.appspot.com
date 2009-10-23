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
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Memo {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private Date date;

    @Persistent
    private Text memo;

    @Persistent
    private Integer status;


    public Memo(String memo, Integer status) {
        this.date = new Date();
        this.memo = new Text(memo);
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    
    public Date getDate() {
        return date;
    }

    public String getMemo() {
        return memo.getValue();
        
    }

    public Integer getStatus() {
        return status;
    }
    
}
