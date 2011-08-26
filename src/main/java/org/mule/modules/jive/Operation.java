package org.mule.modules.jive;

import org.apache.commons.lang.StringUtils;
import org.mule.modules.jive.utils.ServiceUriFactory;

public enum Operation {

	/** Adds an attachment to the specified blog post. */
	BLOG_ADD_ATTACHMENT_TO_BLOG_POST(CustomOp.BLOG_ADD_ATTACHMENT_TO_BLOG_POST),
	/** Adds an image to the specified blog post. */
	BLOG_ADD_IMAGE_TO_BLOG_POST(CustomOp.BLOG_ADD_IMAGE_TO_BLOG_POST),
	/** Creates a new blog. */
	BLOG_CREATE_BLOG(1),
	/** Creates a new blog post.*/
	BLOG_CREATE_BLOG_POST();
	
	private static final int BASE_URI = 1;
	
	private final String resourceUri;
	private final String protocol;
	
	private Operation() {
		this.resourceUri = ServiceUriFactory.generateCustomUri(Service.BLOG, this.toString());
		this.protocol = "POST";
	}
	
	private Operation(final CustomOp customType) {
		this.resourceUri = ServiceUriFactory.generateCustomUri(customType);
		this.protocol = customType.getProtocol();
	}
	
	private Operation(final int strategy) {
		if (strategy == BASE_URI) {
			this.resourceUri = ServiceUriFactory.generateBaseUri(Service.BLOG);
		} else {
			this.resourceUri = "";
		}
		this.protocol = "POST";
	}

	public String getResourceUri() {
		return resourceUri;
	}

	public String getProtocol() {
		return protocol;
	}
	
	/**
     * @return The root tag xml element name for this custom operation.
     */
    public final String getRootTagElementName() {
        final String[] split = StringUtils.split(this.toString(), '_');
        final StringBuffer res = new StringBuffer();
        res.append(split[1].toLowerCase());
        if(split.length > 2) {
            for(int i = 2; i < split.length; i++) {
                res.append(StringUtils.capitalize(split[i].toLowerCase()));
            }
        }
        return res.toString();
    }
	
}
