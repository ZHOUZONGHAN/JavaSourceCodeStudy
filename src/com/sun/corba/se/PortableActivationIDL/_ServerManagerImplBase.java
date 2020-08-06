package com.sun.corba.se.PortableActivationIDL;


/**
* com/sun/corba/se/PortableActivationIDL/_ServerManagerImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-i586-cygwin/jdk8u172/10810/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Wednesday, March 28, 2018 8:21:09 PM PDT
*/


/** Interface used to combine the Activator and Locator when both are
    * implemented together in the same process, as is currently the case
    * for our implementation.
    */
public abstract class _ServerManagerImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements com.sun.corba.se.PortableActivationIDL.ServerManager, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _ServerManagerImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registerServer", new java.lang.Integer (0));
    _methods.put ("serverGoingDown", new java.lang.Integer (1));
    _methods.put ("registerORB", new java.lang.Integer (2));
    _methods.put ("registerPOA", new java.lang.Integer (3));
    _methods.put ("poaDestroyed", new java.lang.Integer (4));
    _methods.put ("activate", new java.lang.Integer (5));
    _methods.put ("shutdown", new java.lang.Integer (6));
    _methods.put ("install", new java.lang.Integer (7));
    _methods.put ("uninstall", new java.lang.Integer (8));
    _methods.put ("getActiveServers", new java.lang.Integer (9));
    _methods.put ("getORBNames", new java.lang.Integer (10));
    _methods.put ("lookupPOATemplate", new java.lang.Integer (11));
    _methods.put ("locateServer", new java.lang.Integer (12));
    _methods.put ("locateServerForORB", new java.lang.Integer (13));
    _methods.put ("getEndpoint", new java.lang.Integer (14));
    _methods.put ("getServerPortForType", new java.lang.Integer (15));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  /** A new ORB started server registers itself with the Activator
	*/
       case 0:  // PortableActivationIDL/Activator/registerServer
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           com.sun.corba.se.PortableActivationIDL.ServerProxy serverObj = com.sun.corba.se.PortableActivationIDL.ServerProxyHelper.read (in);
           this.registerServer (serverId, serverObj);
           out = $rh.createReply();
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         }
         break;
       }


  /** A server is shutting down that was started by this activator.
	* Complete termination of the server is detected by the death of the
	* process implementing the server.
	*/
       case 1:  // PortableActivationIDL/Activator/serverGoingDown
       {
         String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
         this.serverGoingDown (serverId);
         out = $rh.createReply();
         break;
       }


  /** Called whenever an ORB instance is created.  This registers
	* the transport endpoints and the ORB proxy callback object.
	* Note that we cannot detect when an ORB shuts down, although
	* all of the POA shutdowns should still be reported.
	*/
       case 2:  // PortableActivationIDL/Activator/registerORB
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           String orbId = org.omg.PortableInterceptor.ORBIdHelper.read (in);
           com.sun.corba.se.PortableActivationIDL.ORBProxy orb = com.sun.corba.se.PortableActivationIDL.ORBProxyHelper.read (in);
           com.sun.corba.se.PortableActivationIDL.EndPointInfo endPointInfo[] = com.sun.corba.se.PortableActivationIDL.EndpointInfoListHelper.read (in);
           this.registerORB (serverId, orbId, orb, endPointInfo);
           out = $rh.createReply();
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.NoSuchEndPointHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ORBAlreadyRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ORBAlreadyRegisteredHelper.write (out, $ex);
         }
         break;
       }


  /** Construct or find an ORBD object template corresponding to the 
	* server's object template and return it.  Called whenever a 
	* persistent POA is created.
	*/
       case 3:  // PortableActivationIDL/Activator/registerPOA
       {
         String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
         String orbId = org.omg.PortableInterceptor.ORBIdHelper.read (in);
         org.omg.PortableInterceptor.ObjectReferenceTemplate poaTemplate = org.omg.PortableInterceptor.ObjectReferenceTemplateHelper.read (in);
         org.omg.PortableInterceptor.ObjectReferenceTemplate $result = null;
         $result = this.registerPOA (serverId, orbId, poaTemplate);
         out = $rh.createReply();
         org.omg.PortableInterceptor.ObjectReferenceTemplateHelper.write (out, $result);
         break;
       }


  /** Called whenever a POA is destroyed.
	*/
       case 4:  // PortableActivationIDL/Activator/poaDestroyed
       {
         String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
         String orbId = org.omg.PortableInterceptor.ORBIdHelper.read (in);
         org.omg.PortableInterceptor.ObjectReferenceTemplate poaTemplate = org.omg.PortableInterceptor.ObjectReferenceTemplateHelper.read (in);
         this.poaDestroyed (serverId, orbId, poaTemplate);
         out = $rh.createReply();
         break;
       }


  /** If the server is not running, start it up.  This is allowed
	* whether or not the server has been installed.
	*/
       case 5:  // PortableActivationIDL/Activator/activate
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           this.activate (serverId);
           out = $rh.createReply();
         } catch (com.sun.corba.se.PortableActivationIDL.ServerAlreadyActive $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerAlreadyActiveHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerHeldDown $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.write (out, $ex);
         }
         break;
       }


  /** If the server is running, shut it down
	*/
       case 6:  // PortableActivationIDL/Activator/shutdown
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           this.shutdown (serverId);
           out = $rh.createReply();
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotActive $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotActiveHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         }
         break;
       }


  /** Invoke the server install hook.  If the server is not 
	* currently running, this method will activate it.
	*/
       case 7:  // PortableActivationIDL/Activator/install
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           this.install (serverId);
           out = $rh.createReply();
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerHeldDown $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerAlreadyInstalled $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerAlreadyInstalledHelper.write (out, $ex);
         }
         break;
       }


  /** Invoke the server uninstall hook.  If the server is not
	* currently running, this method will activate it.
	* After this hook completes, the server may still be running.
	*/
       case 8:  // PortableActivationIDL/Activator/uninstall
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           this.uninstall (serverId);
           out = $rh.createReply();
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerHeldDown $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerAlreadyUninstalled $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerAlreadyUninstalledHelper.write (out, $ex);
         }
         break;
       }


  /** list active servers
	*/
       case 9:  // PortableActivationIDL/Activator/getActiveServers
       {
         String $result[] = null;
         $result = this.getActiveServers ();
         out = $rh.createReply();
         com.sun.corba.se.PortableActivationIDL.ServerIdsHelper.write (out, $result);
         break;
       }


  /** list all registered ORBs for a server
	*/
       case 10:  // PortableActivationIDL/Activator/getORBNames
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           String $result[] = null;
           $result = this.getORBNames (serverId);
           out = $rh.createReply();
           com.sun.corba.se.PortableActivationIDL.ORBidListHelper.write (out, $result);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         }
         break;
       }


  /** Find the server template that corresponds to the ORBD's
	* adapter id.
	*/
       case 11:  // PortableActivationIDL/Activator/lookupPOATemplate
       {
         String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
         String orbId = org.omg.PortableInterceptor.ORBIdHelper.read (in);
         String orbAdapterName[] = org.omg.PortableInterceptor.AdapterNameHelper.read (in);
         org.omg.PortableInterceptor.ObjectReferenceTemplate $result = null;
         $result = this.lookupPOATemplate (serverId, orbId, orbAdapterName);
         out = $rh.createReply();
         org.omg.PortableInterceptor.ObjectReferenceTemplateHelper.write (out, $result);
         break;
       }


  /** locate server - returns the port with a specific type for all registered
	* ORBs of an active server.
	* Starts the server if it is not already running.
	*/
       case 12:  // PortableActivationIDL/Locator/locateServer
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           String endPoint = in.read_string ();
           com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerType $result = null;
           $result = this.locateServer (serverId, endPoint);
           out = $rh.createReply();
           com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerTypeHelper.write (out, $result);
         } catch (com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.NoSuchEndPointHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerHeldDown $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.write (out, $ex);
         }
         break;
       }


  /** locate server - returns all ports registered with a specified ORB for
	* an active server
	* Starts the server if it is not already running.
	*/
       case 13:  // PortableActivationIDL/Locator/locateServerForORB
       {
         try {
           String serverId = org.omg.PortableInterceptor.ServerIdHelper.read (in);
           String orbId = org.omg.PortableInterceptor.ORBIdHelper.read (in);
           com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORB $result = null;
           $result = this.locateServerForORB (serverId, orbId);
           out = $rh.createReply();
           com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORBHelper.write (out, $result);
         } catch (com.sun.corba.se.PortableActivationIDL.InvalidORBid $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.InvalidORBidHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerNotRegistered $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerNotRegisteredHelper.write (out, $ex);
         } catch (com.sun.corba.se.PortableActivationIDL.ServerHeldDown $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.write (out, $ex);
         }
         break;
       }


  /** get the port for the endpoint of the locator
	*/
       case 14:  // PortableActivationIDL/Locator/getEndpoint
       {
         try {
           String endPointType = in.read_string ();
           int $result = (int)0;
           $result = this.getEndpoint (endPointType);
           out = $rh.createReply();
           out.write_long ($result);
         } catch (com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.NoSuchEndPointHelper.write (out, $ex);
         }
         break;
       }


  /** Useful from external BadServerIdHandlers which need
	* to pick a particular port type.
	*/
       case 15:  // PortableActivationIDL/Locator/getServerPortForType
       {
         try {
           com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORB location = com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORBHelper.read (in);
           String endPointType = in.read_string ();
           int $result = (int)0;
           $result = this.getServerPortForType (location, endPointType);
           out = $rh.createReply();
           out.write_long ($result);
         } catch (com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint $ex) {
           out = $rh.createExceptionReply ();
           com.sun.corba.se.PortableActivationIDL.NoSuchEndPointHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:PortableActivationIDL/ServerManager:1.0", 
    "IDL:PortableActivationIDL/Activator:1.0", 
    "IDL:PortableActivationIDL/Locator:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _ServerManagerImplBase
