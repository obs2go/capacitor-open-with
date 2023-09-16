package app.obserp2go.com.plugin;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class OpenWithPlugin extends Plugin {

    private OpenWith openWith;

    @Override
    public void load() {
        openWith = new OpenWith(getContext());
    }

    @PluginMethod()
    public void openWith(PluginCall call) {
        String path = call.getString("path");
        if (path == null) {
            call.reject("Path is required");
            return;
        }

        try {
            openWith.openFile(path);
            JSObject ret = new JSObject();
            ret.put("message", "File opened successfully");
            call.resolve(ret);
        } catch (Exception e) {
            call.reject("Failed to open file", e);
        }
    }
}

