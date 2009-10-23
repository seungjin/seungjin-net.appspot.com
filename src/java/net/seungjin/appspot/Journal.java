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

import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.datastore.Blob;

/**
 *
 * @author seungjin
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Journal {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private Date date;

    @Persistent
    private String tag;

    @Persistent
    private Text comment;

    @Persistent
    private String ref;

    @Persistent
    private Blob attachement;

    @Persistent
    private String protocol;

    public Journal(String tag, String comment, String ref) {
        //this.date = date;
        this.tag = tag;
        this.comment = new Text(comment);
        this.ref = ref;
    }

    // Accessors for the fields.  JDO doesn't use these, but your application does.

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String category) {
        this.tag = tag;
    }

    public String getComment() {
        return comment.getValue();
    }

    public void setComment(String comment) {
        this.comment = new Text(comment);
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String comment) {
        this.ref = comment;
    }

    public String getXML() {
        StringBuilder resultXML = new StringBuilder();
        resultXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        resultXML.append("<?xml-stylesheet type=\"text/xsl\" href=\"./contents.xsl\"?>");
        resultXML.append("<seungjin>");

        return resultXML.toString();
    }


}
