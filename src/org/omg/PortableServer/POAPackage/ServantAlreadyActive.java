package org.omg.PortableServer.POAPackage;


/**
* org/omg/PortableServer/POAPackage/ServantAlreadyActive.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-i586-cygwin/jdk8u172/10810/corba/src/share/classes/org/omg/PortableServer/poa.idl
* Wednesday, March 28, 2018 8:21:11 PM PDT
*/

public final class ServantAlreadyActive extends org.omg.CORBA.UserException
{

  public ServantAlreadyActive ()
  {
    super(ServantAlreadyActiveHelper.id());
  } // ctor


  public ServantAlreadyActive (String $reason)
  {
    super(ServantAlreadyActiveHelper.id() + "  " + $reason);
  } // ctor

} // class ServantAlreadyActive
