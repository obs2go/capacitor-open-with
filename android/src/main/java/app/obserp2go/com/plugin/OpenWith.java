package app.obserp2go.com.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class OpenWith {

    private Context context;

    public OpenWith(Context context) {
        this.context = context;
    }

    public void openFile(String path) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(path);
        intent.setDataAndType(uri, "*/*");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }
}
