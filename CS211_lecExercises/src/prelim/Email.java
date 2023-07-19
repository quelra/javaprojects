package prelim;
import java.io.File;

/**
    This is the e-mail class that contains the email details subject, recipient, body, attachmentname, sender.
 */
public class Email {
        private String subject;
        private DoublyLinkedList<String> recipients;
        private String body;
        private DoublyLinkedList<File> attachments;
        private String sender;


        //CONSTRUCTORS
        //default constructor
        public Email(){
            subject = null;
            recipients = null;
            body = null;
            attachments = null;
            sender = null;
        }

        //if no attachment given
       public Email(String subject, DoublyLinkedList<String> recipient, String sender,String body){
        this.subject = subject;
        this.recipients = recipient;
        this.sender = sender;
        this.body = body;
        attachments = null;
       }

       //constructor with a given subject, recipient, sender, body, attachment
        public Email(String subject, DoublyLinkedList<String> recipient, String sender,String body, DoublyLinkedList<File> attachment){
            this.subject = subject;
            this.recipients = recipient;
            this.sender = sender;
            this.body = body;
            this.attachments = attachment;
        }

        //SETTERS
        public void setSubject(String subject){
            this.subject = subject;
        }

        public void setRecipient(DoublyLinkedList<String> recipient){
            this.recipients = recipient;
        }

        public void setSender(String sender){
            this.sender = sender;
        }

        public void setBody(String body){
            this.body  = body;
        }

        public void setAttachments(DoublyLinkedList<File> attachments){
            this.attachments = attachments;
        }

        //GETTERS
        public String getSubject(){
            return subject;
        }

        public DoublyLinkedList<String> getRecipient(){
            return recipients;
        }

        public String getSender(){
            return sender;
        }

        public String getBody(){
            return body;
        }

        public DoublyLinkedList<File> getAttachments(){
            return attachments;
        }

        public boolean equals(Email another){
            return another.getBody().compareTo(this.getBody()) == 0;
        }
}