package org.projectodd.nodej;

import java.util.ArrayList;

import org.dynjs.runtime.DynObject;
import org.dynjs.runtime.GlobalObject;
import org.dynjs.runtime.PropertyDescriptor;

/**
 * A <code>Process</code> is a node.js application.
 * 
 * @author Bob McWhirter
 * @author Lance Ball
 */
public class Process extends DynObject {

	public Process(GlobalObject globalObject, String[] args) {
	    super(globalObject);
        setProperty("argv", args );
	    setProperty("stdout", globalObject.getConfig().getOutputStream());
        setProperty("stderr", globalObject.getConfig().getErrorStream());
        setProperty("arch", "java" );
        setProperty("platform", "java" );
        setProperty("version", Node.VERSION );

        // These seem to be undocumented in node, but are required?
        setProperty("noDeprecation", false);        
        setProperty("traceDeprecation", false);
        
		setWritableProperty("title", "nodej" );
		
		setProperty("moduleLoadList", new ArrayList<String>() );
		setProperty("versions", new Versions(globalObject) );
		
		setProperty("execArgv", null );
		setProperty("env", null );
		setProperty("pid", null );
		setProperty("features", null );
		setProperty("_eval", null );
		setProperty("_print_eval", null );
		setProperty("_forceRepl", null );
		setProperty("execPath", null );
		setProperty("debugPort", null );
		
		setProperty("_needTickCallback", null );
		setProperty("reallyExit", null );
		setProperty("abort", null );
		setProperty("chdir", null );
		setProperty("cwd", null );
		setProperty("umask", null );
		setProperty("getuid", null );
		setProperty("setuid", null );
		setProperty("getgid", null );
		setProperty("setgid", null );
		setProperty("_kill", null );
		setProperty("_debugProcess", null );
		setProperty("_debugPause", null );
		setProperty("_debugEnd", null );
		setProperty("hrtime", null );
		setProperty("dlopen", null );
		setProperty("uptime", null );
		setProperty("memoryUsage", null );
		//setProperty("uvCounters", null );
		setProperty("binding", null );
		
		// Tell the world we exist!
	    //globalObject.defineGlobalProperty("process", this);
	    //globalObject.put(null, "process", this, false);
	}
	
    protected void setProperty(String name, final Object value) {
        this.defineOwnProperty(null, name, new PropertyDescriptor() {
            {
                set("Value", value );
                set("Writable", false);
                set("Enumerable", false);
                set("Configurable", false);
            }
        }, false);
    }

    protected void setWritableProperty(String name, final Object value) {
        this.defineOwnProperty(null, name, new PropertyDescriptor() {
            {
                set("Value", value );
                set("Writable", true);
                set("Enumerable", false);
                set("Configurable", false);
            }
        }, false);
    }
}