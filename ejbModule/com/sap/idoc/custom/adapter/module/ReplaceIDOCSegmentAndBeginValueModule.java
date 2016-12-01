package com.sap.idoc.custom.adapter.module;

import java.io.ByteArrayOutputStream;

import javax.ejb.Local;
import javax.ejb.LocalHome;
import javax.ejb.Remote;
import javax.ejb.RemoteHome;
import javax.ejb.Stateless;

import com.sap.aii.af.lib.mp.module.Module;
import com.sap.aii.af.lib.mp.module.ModuleContext;
import com.sap.aii.af.lib.mp.module.ModuleData;
import com.sap.aii.af.lib.mp.module.ModuleException;
import com.sap.aii.af.lib.mp.module.ModuleHome;
import com.sap.aii.af.lib.mp.module.ModuleLocal;
import com.sap.aii.af.lib.mp.module.ModuleRemote;
import com.sap.engine.interfaces.messaging.api.Message;
import com.sap.engine.interfaces.messaging.api.MessageKey;
import com.sap.engine.interfaces.messaging.api.PublicAPIAccessFactory;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditAccess;
import com.sap.engine.interfaces.messaging.api.auditlog.AuditLogStatus;
import com.sap.engine.interfaces.messaging.api.exception.MessagingException;
import com.sap.aii.af.lib.mp.module.ModuleLocalHome;

/**
 * Session Bean implementation class ReplaceIDOCSegmentAndBeginValueModule
 */
@Stateless(name = "ReplaceIDOCSegmentAndBeginValue")
@Local(value = { ModuleLocal.class })
@Remote(value = { ModuleRemote.class })
@LocalHome(value = ModuleLocalHome.class)
@RemoteHome(value = ModuleHome.class)
public class ReplaceIDOCSegmentAndBeginValueModule implements Module {

	
private static String [] SEARCH ={"\\bSEGMENT=\"\\W*\"\\B" +"|"+ 
			   					  "\\bSEGMENT=\"\\w*\"\\B" +"|"+
			   					  "\\bSEGMENT=\"\\d*\"\\B" +"|"+
			   					  "\\bSEGMENT=\"\\D*\"\\B" +"|"+
			   					  "\\bSEGMENT=\"\\s*\"\\B" +"|"+
			   					  "\\bSEGMENT=\"\\S*\"\\B" +"|"+
			   					  "SEGEMENT=\"\"",
			   					  "\\bBEGIN=\"\\W*\"\\B" +"|"+
			   					  "\\bBEGIN=\"\\w*\"\\B" +"|"+
			   					  "\\bBEGIN=\"\\d*\"\\B" +"|"+
			   					  "\\bBEGIN=\"\\D*\"\\B" +"|"+
			   					  "\\bBEGIN=\"\\s*\"\\B" +"|"+
			   					  "\\bBEGIN=\"\\S*\"\\B" +"|"+
			   					  "BEGIN=\"\""};
			   								   

	/**
	 * Default constructor.
	 */
	public ReplaceIDOCSegmentAndBeginValueModule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ModuleData process(ModuleContext context, ModuleData data) throws ModuleException {
		AuditAccess audit = null;
		Object obj = null;
		Message msg = null;
		MessageKey key = null;
		try {
			obj = data.getPrincipalData();
			msg = (Message) obj;
			key = new MessageKey(msg.getMessageId(), msg.getMessageDirection());
			audit = PublicAPIAccessFactory.getPublicAPIAccess().getAuditAccess();
			audit.addAuditLogEntry(key, AuditLogStatus.SUCCESS, "IDOC SEGMENT AND BEGIN VALUE REPLACEMENT START");
			ReplaceIDOCSegmentAndBeginValue replace=new ReplaceIDOCSegmentAndBeginValue();
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			replace.execute(msg.getDocument().getInputStream(),out, SEARCH);
			audit.addAuditLogEntry(key, AuditLogStatus.SUCCESS, "IDOC SEGMENT AND BEGIN VALUE REPLACEMENT END");
			msg.getDocument().setContent(out.toByteArray());
			
		} catch (MessagingException e) {
			audit.addAuditLogEntry(key, AuditLogStatus.ERROR, e.toString());
			throw new ModuleException(e);
		} catch (ReplaceIDOCSegementAndBeginValueException e) {
			audit.addAuditLogEntry(key, AuditLogStatus.ERROR, e.toString());
			throw new ModuleException(e);
		}

		return data;
	}

}
