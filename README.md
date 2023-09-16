# obs2go-open-with

Open with prompt for local files

## Install

```bash
npm install obs2go-open-with
npx cap sync
```

In AndroidMainfest.xml
```xml
<application>
 ....
    <provider
        android:name="androidx.core.content.FileProvider"
        android:authorities="${applicationId}.fileprovider"
        android:exported="false"
        android:grantUriPermissions="true">
        <meta-data
            android:name="android.support.FILE_PROVIDER_PATHS"
            android:resource="@xml/file_paths" />
    </provider>
</application>
```

In src/main/res/xml/filepaths.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<paths xmlns:android="http://schemas.android.com/apk/res/android">
    <external-path name="external_files" path="Download/" />
    <cache-path name="my_cache_images" path="Download/" />
    <files-path name="files" path="Download/" />
    <cache-path name="cache" path="Download/" />
    <external-cache-path name="external_cache" path="Download/" />
</paths>
```

Replace "Download/" with "." if applicable

## Usage 

```javascript
import { Plugins } from '@capacitor/core';

const { OpenWithPlugin }  = Plugins;

@Injectable()
export class YorClass {
    async openWith(path: string) {
        try {
            OpenWithPlugin.openWith({ path });
        } catch (error) {
            console.error('Error opening file:', error);
        }
    }

    protected async openFilePrompt() {
        ....
        this.openWith("file://....");
    }
}
```

## API

<docgen-index></docgen-index>

<docgen-api>
<!-- run docgen to generate docs from the source -->
<!-- More info: https://github.com/ionic-team/capacitor-docgen -->
</docgen-api>
