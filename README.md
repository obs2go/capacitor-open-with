# obs2go-open-with

This is a capacitor plugin that allows the user to open a specific file using their preferred application on the device.

## Install

```bash
npm install https://github.com/obs2go/capacitor-open-with
npx cap sync
```

Android

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

iOS - add /NSPhotoLibraryUsageDescription to Info.plist

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

<docgen-index>
openWith
</docgen-index>

<docgen-api>
<!-- run docgen to generate docs from the source -->
<!-- More info: https://github.com/ionic-team/capacitor-docgen -->
Accepts one parameter: file path
Example Format: file://storage/emulator/0/....
</docgen-api>

## Supported Platforms

iOS and Android

