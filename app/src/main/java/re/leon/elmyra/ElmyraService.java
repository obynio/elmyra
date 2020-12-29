package re.leon.elmyra;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.service.voice.VoiceInteractionService;
import android.widget.Toast;

public class ElmyraService extends VoiceInteractionService {
    public static boolean isFlashlightOn = false;

    @Override
    public void onCreate(){
        super.onCreate();

        CameraManager cameraManager = (CameraManager) getBaseContext().getSystemService(Context.CAMERA_SERVICE);
        cameraManager.registerTorchCallback(torchCallback, null);
    }


    @Override
    public void onDestroy(){
        super.onCreate();

        CameraManager cameraManager = (CameraManager) getBaseContext().getSystemService(Context.CAMERA_SERVICE);
        cameraManager.unregisterTorchCallback(torchCallback);
    }

    private static CameraManager.TorchCallback torchCallback = new CameraManager.TorchCallback() {
        @Override
        public void onTorchModeChanged(String cameraId, boolean enabled) {
            super.onTorchModeChanged(cameraId, enabled);
            isFlashlightOn = enabled;
        }
    };
}