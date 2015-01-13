//* Licensed Materials - Property of                                  *
//* IBM                                                               *
//*                                                                   *
//* eu.abc4trust.pabce.1.34                                           *
//*                                                                   *
//* (C) Copyright IBM Corp. 2014. All Rights Reserved.                *
//* US Government Users Restricted Rights - Use, duplication or       *
//* disclosure restricted by GSA ADP Schedule Contract with IBM Corp. *
//*                                                                   *
//* This file is licensed under the Apache License, Version 2.0 (the  *
//* "License"); you may not use this file except in compliance with   *
//* the License. You may obtain a copy of the License at:             *
//*   http://www.apache.org/licenses/LICENSE-2.0                      *
//* Unless required by applicable law or agreed to in writing,        *
//* software distributed under the License is distributed on an       *
//* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY            *
//* KIND, either express or implied.  See the License for the         *
//* specific language governing permissions and limitations           *
//* under the License.                                                *
//*/**/****************************************************************

package eu.abc4trust.smartcard;

import java.io.Serializable;
import java.math.BigInteger;
import java.net.URI;
import java.util.Random;

public class CredentialOnSmartcard implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -7889698019565662678L;
  public final URI credentialUid;
  public final URI parametersUri;
  public final BigInteger v;
  public boolean issued;
  
  public CredentialOnSmartcard(URI credentialUid, URI parametersUri, BigInteger v) {
    this.credentialUid = credentialUid;
    this.parametersUri = parametersUri;
    this.v = v;
    this.issued = false;
  }
  
  public CredentialOnSmartcard(URI credentialUid, URI parametersUri, Random rand,
                               int sizeOfModulusInBits, int zkStatisticalSizeInBytes) {
    this.credentialUid = credentialUid;
    this.parametersUri = parametersUri;
    
    int credentialRandomizerSizeInBits =
        sizeOfCourseRandomizerInBits(sizeOfModulusInBits, zkStatisticalSizeInBytes);
    this.v = new BigInteger(credentialRandomizerSizeInBits, rand);
    this.issued = false;
  }
  
  static int sizeOfCourseRandomizerInBits(int sizeOfModulusInBits, int zkStatisticalHidingSizeBytes) {
    int lengthModulusBytes = (sizeOfModulusInBits + 7) / 8;
    int credentialRandomizerSizeBytes = lengthModulusBytes + zkStatisticalHidingSizeBytes;
    return credentialRandomizerSizeBytes * 8;
  }
}
