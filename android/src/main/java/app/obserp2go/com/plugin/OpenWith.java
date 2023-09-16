package app.obserp2go.com.plugin;

import android.util.Log;

public class OpenWith {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    @PluginMethod
    public void openWith(PluginCall call) {
        String path = call.getString("path");
        if (path == null) {
            call.reject("Path is required");
            return;
        }

        File file = new File(path);
        if (!file.exists()) {
            call.reject("File does not exist");
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = FileProvider.getUriForFile(getContext(), getContext().getPackageName() + ".fileprovider", file);
        intent.setDataAndType(uri, "application/*");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            getContext().startActivity(intent);
            call.success();
        } catch (ActivityNotFoundException e) {
            call.reject("No application found to open the file");
        }
    }
}
