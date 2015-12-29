
package com.deere.api.axiom.generated.v3;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    private final static long serialVersionUID = 1L;
    protected String rel;
    protected String uri;
    protected Boolean followable;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean isFollowable() {
        return followable;
    }

    public void setFollowable(Boolean followable) {
        this.followable = followable;
    }
}
