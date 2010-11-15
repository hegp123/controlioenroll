package enroll;

import app.Principal;
import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.processing.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class EnrollmentForm extends CaptureForm
{
	private DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();
	
	public EnrollmentForm(Frame owner) {
		super(owner);
	}
	
	@Override protected void init()
	{
		super.init();
		this.setTitle("Capturador de huellas");
		updateStatus();
	}

	@Override protected void process(DPFPSample sample) {
		super.process(sample);
		// Process the sample and create a feature set for the enrollment purpose.
		DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		// Check quality of the sample and add to enroller if it's good
		if (features != null) try
		{
			makeReport("La huella ha sido creada");
			enroller.addFeatures(features);		// Add feature set to template.
		}
		catch (DPFPImageQualityException ex) { }
		finally {
			updateStatus();

			// Check if template has been created.
			switch(enroller.getTemplateStatus())
			{
				case TEMPLATE_STATUS_READY:	// report success and stop capturing
					stop();
					//((MainForm)getOwner()).setTemplate(enroller.getTemplate());
                                        ((Principal)getOwner()).setTemplate(enroller.getTemplate());
					setPrompt("Haga click en cerrar y luego en verificar huella");
					break;

				case TEMPLATE_STATUS_FAILED:	// report failure and restart capturing
					enroller.clear();
					stop();
					updateStatus();
					//((MainForm)getOwner()).setTemplate(null);
                                        ((Principal)getOwner()).setTemplate(null);
					JOptionPane.showMessageDialog(EnrollmentForm.this, "La muestra de la huella no es valida. Debe repetir el proceso de captura de huella.", "Capturar Huella", JOptionPane.ERROR_MESSAGE);
					start();
					break;
			}
		}
	}
	
	private void updateStatus()
	{
		// Show number of samples needed.
		setStatus(String.format("Se necesitan  %1$s muestras de la huella: ", enroller.getFeaturesNeeded()));
	}
	
}
