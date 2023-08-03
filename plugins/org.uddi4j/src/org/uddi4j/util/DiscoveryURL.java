/*
 * The source code contained herein is licensed under the IBM Public License
 * Version 1.0, which has been approved by the Open Source Initiative.
 * Copyright (C) 2001, International Business Machines Corporation
 * All Rights Reserved.
 *
 */

package org.uddi4j.util;

import org.uddi4j.UDDIElement;
import org.uddi4j.UDDIException;
import org.w3c.dom.Element;

/**
 * Represents the discoveryURL element within the UDDI version 2.0 schema.
 * This class contains the following types of methods:
 * 
 * <ul>
 *   <li>A constructor that passes the required fields.
 *   <li>A Constructor that will instantiate the object from an appropriate XML
 *       DOM element.
 *   <li>Get/set methods for each attribute that this element can contain.
 *   <li>A get/setVector method is provided for sets of attributes.
 *   <li>A SaveToXML method that serializes this class within a passed in
 *       element.
 * </ul>
 * 
 * Typically, this class is used to construct parameters for, or interpret
 * responses from, methods in the UDDIProxy class.
 *
 * <p><b>Element description:</b>
 * <p>Data:  A url pointing to an external (typed by convention) discovery doc.
 * 
 * @author David Melgar (dmelgar@us.ibm.com)
 */
public class DiscoveryURL extends UDDIElement {

   public static final String UDDI_TAG = "discoveryURL";

   protected Element base = null;

   String text = null;
   String useType = null;

   /**
    * Default constructor.
    * Avoid using the default constructor for validation. It does not validate
    * required fields. Instead, use the required fields constructor to perform
    * validation.
    */
   public DiscoveryURL() {
   }

   /**
    * Construct the object with required fields.
    *
    * @param value  String value
    * @param useType  String
    */
   public DiscoveryURL(String value,
      String useType) {
      setText(value);
      this.useType = useType;
   }

   /**
    * Construct the object from a DOM tree. Used by
    * UDDIProxy to construct an object from a received UDDI
    * message.
    *
    * @param base   Element with the name appropriate for this class.
    *
    * @exception UDDIException Thrown if DOM tree contains a SOAP fault
    *  or a disposition report indicating a UDDI error.
    */
   public DiscoveryURL(Element base) throws UDDIException {
      // Check if it is a fault. Throws an exception if it is.
      super(base);
      text = getText(base);
      useType = base.getAttribute("useType");
   }

   public void setText(String s) {
      text = s;
   }

   public void setUseType(String s) {
      useType = s;
   }

   public String getText() {
      return text;
   }

   public String getUseType() {
      return useType;
   }

   public boolean equals(Object obj)
   {
       boolean result = false;
       if (obj != null && obj instanceof DiscoveryURL)
       {
           DiscoveryURL otherDiscURL = (DiscoveryURL)obj;
           if ((text == null && otherDiscURL.getText() == null) ||
               (text != null && text.equals(otherDiscURL.getText())))
           {
               if ((useType == null && otherDiscURL.getUseType() == null) ||
                   (useType != null && useType.equals(otherDiscURL.getUseType())))
               {
                   result = true;
               }
           }
       }
       return result;
   }

   /**
    * Save an object to the DOM tree. Used to serialize an object
    * to a DOM tree, usually to send a UDDI message.
    *
    * <BR>Used by UDDIProxy.
    *
    * @param parent Object will serialize as a child element under the
    *  passed in parent element.
    */
   public void saveToXML(Element parent) {
      base = parent.getOwnerDocument().createElementNS(UDDIElement.XMLNS, UDDIElement.XMLNS_PREFIX + UDDI_TAG);
      // Save attributes.
      if (text!=null) {
         base.appendChild(parent.getOwnerDocument().createTextNode(text));
      }
      if (useType!=null) {
         base.setAttribute("useType", useType);
      }
      parent.appendChild(base);
   }
}
