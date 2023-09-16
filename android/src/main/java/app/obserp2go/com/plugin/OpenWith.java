package app.obserp2go.com.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

public class OpenWith {

    private Context context;

    public OpenWith(Context context) {
        this.context = context;
    }

    public void openFile(String path) {
        File file = new File(path);
        Uri fileUri = FileProvider.getUriForFile(
            context,
            context.getApplicationContext().getPackageName() + ".provider",
            file
        );

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(fileUri, "*/*");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);

        context.startActivity(intent);
    }
}
