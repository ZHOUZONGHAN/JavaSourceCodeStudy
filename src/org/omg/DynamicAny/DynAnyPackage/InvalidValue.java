package org.omg.DynamicAny.DynAnyPackage;


/**
* org/omg/DynamicAny/DynAnyPackage/InvalidValue.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-i586-cygwin/jdk8u172/10810/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Wednesday, March 28, 2018 8:21:09 PM PDT
*/

public final class InvalidValue extends org.omg.CORBA.UserException
{

  public InvalidValue ()
  {
    super(InvalidValueHelper.id());
  } // ctor


  public InvalidValue (String $reason)
  {
    super(InvalidValueHelper.id() + "  " + $reason);
  } // ctor

} // class InvalidValue
