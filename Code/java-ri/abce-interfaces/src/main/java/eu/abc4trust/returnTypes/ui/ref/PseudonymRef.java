//* Licensed Materials - Property of IBM                              *
//* eu.abc4trust.pabce.1.0                                            *
//* (C) Copyright IBM Corp. 2012. All Rights Reserved.                *
//* US Government Users Restricted Rights - Use, duplication or       *
//* disclosure restricted by GSA ADP Schedule Contract with IBM Corp. *
//*/**/****************************************************************

package eu.abc4trust.returnTypes.ui.ref;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;

import eu.abc4trust.returnTypes.ui.PseudonymInUi;

@XmlType
public class PseudonymRef {

  @XmlIDREF
  @XmlAttribute(name = "ref")
  public PseudonymInUi pseudonym;
  
  public PseudonymRef() {
  }
  
  public PseudonymRef(PseudonymInUi pseudonym) {
    this.pseudonym = pseudonym;
  }
}
