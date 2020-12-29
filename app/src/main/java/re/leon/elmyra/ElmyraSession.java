package re.leon.elmyra;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.util.Log;
import android.widget.Toast;

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

        try {
            CameraManager cameraManager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);
            cameraManager.setTorchMode(getCameraId(getContext()), !ElmyraService.isFlashlightOn);
        } catch (CameraAccessException e) {
            Log.d(getClass().getSimpleName(), e.toString());
        }
    }

    private String getCameraId(Context context) {
        CameraManager cameraManager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);

        try {
            String[] cameraList = cameraManager.getCameraIdList();

            for (String cameraId : cameraList) {
                CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);

                boolean isFlashAvailable = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                boolean isCameraFacingBack = characteristics.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_BACK;

                if (isFlashAvailable && isCameraFacingBack) {
                    return cameraId;
                }
            }
        } catch (CameraAccessException e) {
            Log.d(getClass().getSimpleName(), e.toString());
        }

        return null;
    }
}
