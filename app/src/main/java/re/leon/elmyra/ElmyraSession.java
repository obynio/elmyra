package re.leon.elmyra;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.util.Log;

public class ElmyraSession extends VoiceInteractionSession {
    public ElmyraSession(Context context) {
        super(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onAssistStructureFailure(Throwable failure) {
        super.onAssistStructureFailure(failure);

        Log.e(getClass().getSimpleName(), "onAssistStructureFailure", failure);
    }

    @Override
    public void onHandleAssist(Bundle data, AssistStructure structure, AssistContent content) {
        super.onHandleAssist(data, structure, content);

        hide();
        flashLightOn();
    }

    private void flashLightOn() {
        CameraManager cameraManager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
        } catch (CameraAccessException e) {
            Log.d(getClass().getSimpleName(), e.toString());
        }
    }
}
