package enroll;

import app.Principal;
import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.verification.*;
import java.awt.*;

public class VerificationForm extends CaptureForm
{
	private DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();
	
	public VerificationForm(Frame owner) {
		super(owner);
	}
	
	@Override protected void init()
	{
		super.init();
		this.setTitle("Capturador de huellas");
		updateStatus(0);
	}

	@Override protected void process(DPFPSample sample) {
		super.process(sample);

		// Process the sample and create a feature set for the enrollment purpose.
		DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

		// Check quality of the sample and start verification if it's good
		if (features != null)
		{
			// Compare the feature set with our template
			DPFPVerificationResult result = 
				verificator.verify(features, ((MainForm)getOwner()).getTemplate());
                                //verificator.verify(features, ((Principal)getOwner()).getTemplate());
			updateStatus(result.getFalseAcceptRate());
			if (result.isVerified())
				makeReport("La huella ha sido VERIFICADA.");
			else
				makeReport("La huella no ha sido VERIFICADA.");
		}
	}
	
	private void updateStatus(int FAR)
	{
		// Show "False accept rate" value
		setStatus(String.format("Ratio de aceptacion (False Accept Rate)(FAR) = %1$s", FAR));
	}

}
