package prelim;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GmailTest4 {
    private static DoublyLinkedList<DoublyLinkedList> inbox = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> primary = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> social = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> promotions = new DoublyLinkedList<>();

    private static DoublyLinkedList<Email> starred = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> snoozed = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> sent = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> drafts = new DoublyLinkedList<>();

    private static DoublyLinkedList<DoublyLinkedList> more = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> important = new DoublyLinkedList<>();
    private static DoublyLinkedList<Email> spam = new DoublyLinkedList<>();
    private static  DoublyLinkedList<Email> trash = new DoublyLinkedList<>();

    public static void main(String[] args) throws ListOverflowException {
        GmailTest4 program;

        try {
            program = new GmailTest4();
            program.run();
        } catch (Exception e) {
            System.out.println("An exception has occured");
            e.printStackTrace();
        }
    }

    public void run() throws ListOverflowException, IOException {
        readSampleEmailsReceived(); //read sample emails from a file and insert to corresponding lists (primary,social,promotions)

        inbox.insert(primary);
        inbox.insert(social);
        inbox.insert(promotions);

        more.insert(important);
        more.insert(spam);
        more.insert(trash);

        boolean exit = false;

        while(!exit) {
            showMenu();
            System.out.print("Menu Choice: ");
            int choice = getIntInput(); //Menu option chosen
            switch (choice) {
                case 1:
                    System.out.println("\nCompose email");
                    composeEmail();
                    break;
                case 2:
                    System.out.println("\nGmail menu>Inbox");
                    showInboxSubMenu();
                    int choice3 = getIntInput();
                    switch (choice3){
                        case 1:
                            System.out.println("\nGmail menu>Inbox>Primary");
                            showListOfEmails(primary);
                            CRUDMenu("primary",primary);
                            break;
                        case 2:
                            System.out.println("\nGmail menu>Inbox>Social");
                            showListOfEmails(social);
                            CRUDMenu("social",social);
                            break;
                        case 3:
                            System.out.println("\nGmail menu>Inbox>Promotions");
                            showListOfEmails(promotions);
                            CRUDMenu("promotions",promotions);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\nGmail menu>Starred");
                    showListOfEmails(starred);
                    otherMenu("starred",starred);
                    break;
                case 4:
                    System.out.println("\nGmail menu>Snoozed");
                    showListOfEmails(snoozed);
                    otherMenu("snoozed",snoozed);
                    break;
                case 5:
                    System.out.println("\nGmail menu>Sent");
                    showListOfEmails(sent);
                    otherMenu("sent",sent);
                    break;
                case 6:
                    System.out.println("\nGmail menu>Drafts");
                    showListOfEmails(drafts);
                    menuForDraft("drafts");
                    break;
                case 7:
                    System.out.println("\nGmail menu>More");
                    showMoreSubMenu();
                    int choice2 = getIntInput();
                    switch (choice2){
                        case 1:
                            System.out.println("\nGmail menu>More>Important");
                            showListOfEmails(important);
                            otherMenu("important",important);
                            break;
                        case 2:
                            System.out.println("\nGmail menu>More>Spam");
                            showListOfEmails(spam);
                            otherMenu("spam",spam);
                            break;
                        case 3:
                            System.out.println("\nGmail menu>More>Trash");
                            showListOfEmails(trash);
                            otherMenu("trash",trash);
                            break;
                    }
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("\nPlease input a valid menu option");
            }
        }
        //End of menu loop
    }

    /**
     * Displays the menu options for the list of mails.
     */
    public void showMenu() {
        System.out.println("\nGmail menu");
        System.out.println("1 : Compose email");
        System.out.println("2 : Inbox");
        System.out.println("3 : Starred");
        System.out.println("4 : Snoozed");
        System.out.println("5 : Sent");
        System.out.println("6 : Drafts");
        System.out.println("7 : More");
        System.out.println("8 : Exit");
    }

    public void showMoreSubMenu(){
        System.out.println("\nGmail Menu>More");
        System.out.println("1. Important");
        System.out.println("2. Spam");
        System.out.println("3. Trash");
        System.out.println("0. Go back");
    }

    public void showInboxSubMenu(){
        System.out.println("\nGmail Menu>Inbox");
        System.out.println("1. Primary");
        System.out.println("2. Social");
        System.out.println("3. Promotions");
        System.out.println("0. Go back");
    }

    public void menuForCRUD(){
        System.out.println("Select menu");
        System.out.println("1. Open");
        System.out.println("2. Delete");
        System.out.println("3. Add star");
        System.out.println("4. Snooze");
        System.out.println("5. Mark as Important");
        System.out.println("6. Report Spam");
        System.out.println("7. Exit menu");

    }

    public void menuForOthers(){// eto ibang menu ng nasa important, spam etc. na list
        System.out.println("Select Menu");
        System.out.println("1. Open");
        System.out.println("2. Remove from list");
        System.out.println("0. Return to main menu");
    }


    /**
     * Returns a valid integer using the scanner class.
     */
    public int getIntInput() {
        boolean isValid = false;
        int val =0;
        Scanner kb = new Scanner(System.in);
        while (!isValid) {
            try {
                val = Integer.parseInt(kb.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid integer");
            }
        }
        return val;
    }

    public void CRUDMenu(String listName, DoublyLinkedList<Email> list) throws ListOverflowException {
        boolean exit = false;
        Email selectedEmail = selectEmail(list);
        if(selectedEmail==null){
            exit=true;
        }

        while(!exit) {
            menuForCRUD();
            int choice = getIntInput(); //Menu option chosen
            switch (choice) {
                case 1:
                    System.out.println("\nOpening Email");
                    open(list,selectedEmail);
                    break;
                case 2:
                    System.out.println("\nDeleting Email");
                    deleteEmail(listName, selectedEmail);
                    exit = true;
                    break;
                case 3:
                    System.out.println("\nStarred");
                    addToStarred(selectedEmail);
                    exit = true;
                    break;
                case 4:
                    System.out.println("\n Snoozed");
                    snooze(listName, selectedEmail);
                    exit = true;
                    break;
                case 5:
                    System.out.println("\n Marked as Important");
                    markImportant(list,selectedEmail);
                    exit = true;
                    break;
                case 6:
                    System.out.println("\n Adding to spam");
                    addToSpam(listName,selectedEmail);
                    exit = true;
                    break;
                case 7:
                    exit=true;
                    break;
                default:
                    System.out.println("\nPlease input a valid menu option");
            }
        }
        //End of menu loop
    }

    //ok
    public void otherMenu(String listName,DoublyLinkedList<Email> list) throws ListOverflowException {
        boolean exit = false;
        Email selectedEmail = selectEmail(list);
        if(selectedEmail==null){
            exit=true;
        }

        while(!exit) {
            menuForOthers();
            int choice = getIntInput(); //Menu option chosen
            switch (choice) {
                case 1:
                    System.out.println("\nOpening Email");
                    open(list,selectedEmail);
                    break;
                case 2:
                    System.out.println("\nRemove from list");
                    switch (listName){
                        case "snooze":
                            returnToInbox("snooze",selectedEmail);
                            break;
                        case "spam":
                            returnToInbox("spam",selectedEmail);
                            break;
                    }
                    deleteEmail(listName,selectedEmail);
                case 0:
                    exit=true;
                    break;
                default:
                    System.out.println("\nPlease input a valid menu option");
            }
        }
    }

    public void menuForDraft(String listName) throws ListOverflowException {
        Scanner keyboard = new Scanner(System.in);
        boolean run = true;
        byte choice;
        Email editMail = new Email();
        Email mail = selectEmail(drafts);
        if(mail==null){
            run=false;
        }

        while(run){
            System.out.println("What do you want to do with the draft?");
            System.out.println("[1] Open draft");
            System.out.println("[2] Edit draft");
            System.out.println("[3] Send draft");
            System.out.println("[4] Remove draft");
            System.out.println("[5] Exit");
            System.out.println("Choice: ");
            choice = keyboard.nextByte();
            switch(choice){
                case 1:
                    System.out.println("Opening draft");
                    open(drafts,mail);
                    break;
                case 2:
                    System.out.println("Editing draft");
                    editMail = editDraft(mail);
                    deleteEmail(listName,mail);
                    drafts.insert(editMail);
                    break;
                case 3:
                    System.out.println("Sending draft");
                    sent.insert(mail);
                    deleteEmail(listName,mail);
                    System.out.println("Successfully sent");
                    run=false;
                    break;
                case 4:
                    deleteEmail(listName,mail);
                    System.out.println("Email removed");
                    run=false;
                    break;
                case 5:
                    run=false;
                    break;
                default :
                    System.out.println("Please enter a number from 1 to 5");
                    break;
            }
        }
    }

    public Email editDraft(Email mail) throws ListOverflowException {
        Email editedMail = new Email();
        Scanner scan = new Scanner(System.in);

        System.out.println("Editing Subject \n");
        System.out.println("Previous Subject: " + mail.getSubject());
        System.out.println("New Subject: \n");
        editedMail.setSubject(scan.nextLine());

        System.out.println("\nEditing Recipients: ");
        System.out.println("Previous Recipients: " );
        mail.getRecipient().show();
        System.out.println("\nNew Recipients");
        editedMail.setRecipient(insertRecipients());

        editedMail.setSender("me");

        System.out.println("\n Editing Body");
        System.out.println("Previous Body: " + mail.getBody());
        System.out.println("\nNew Body: ");
        editedMail.setBody(scan.nextLine());

        System.out.println("\n Editing Attachments");
        System.out.println("Previous Attachments: ");
        mail.getAttachments().show();
        System.out.println("\nNew Attachments: ");
        editedMail.setAttachments(insertAttachments());

        System.out.println("Email successfully edited");

        return editedMail;

    }

    public void returnToInbox(String listName, Email email) throws ListOverflowException {
        switch(listName){
            case "social":
                social.insert(email);
                break;
            case "promotions":
                promotions.insert(email);
                break;
            default: //if no specified listName, will go to primary
                primary.insert(email);
                break;
        }
    }
    /**
     * Shows the contents of a Doubly-Linked List of Emails
     */
    public void showListOfEmails(DoublyLinkedList<Email> list) {
        int counter = 1;

        if(list.isEmpty()){
            System.out.println("Nothing to show.");
        } else{
            while(counter<=list.getSize()){

                System.out.println("[" + counter + "] " + "Sender: " + list.getElementFromNumber(counter).getSender() +
                        "\nSubject: " + list.getElementFromNumber(counter).getSubject());
                counter++;
            }
        }
    }

    public DoublyLinkedList<String> insertRecipients() throws ListOverflowException {
        Scanner keyboard = new Scanner(System.in);
        DoublyLinkedList<String> Recipients = new DoublyLinkedList<>();
        String choice;

        System.out.print("Email/Name of recipient: ");
        Recipients.insert(keyboard.nextLine());

        boolean add = true;
        while(add){
            System.out.println("\n[1] Add another recipient");
            System.out.println("[2] Done");
            System.out.print("Choice: ");
            choice = keyboard.nextLine();
            switch(choice){
                case "1":
                    System.out.print("Email/Name of recipient: ");
                    Recipients.insert(keyboard.nextLine());
                    break;
                case "2":
                    add = false;
                    break;
                default :
                    System.out.println("Please enter only 1 or 2");
                    break;
            }
        }
        return Recipients;
    }

    public DoublyLinkedList<File> insertAttachments() throws ListOverflowException {
        System.out.println("\nAttachments: ");

        DoublyLinkedList<File> fileList = new DoublyLinkedList<>();
        Scanner keyboard = new Scanner(System.in);
        String choice, fileName;
        File file;

        boolean add = true;
        while(add){
            System.out.println("\n[1] Add file");
            System.out.println("[2] Done");
            System.out.print("Choice: ");
            choice = keyboard.nextLine();
            switch(choice){
                case "1":
                    System.out.print("Name of file: ");
                    fileName =  keyboard.nextLine();
                    file = new File("Files\\"+fileName);
                    fileList.insert(file);
                    break;
                case "2":
                    add = false;
                    break;
                default :
                    System.out.println("Please enter only 1 or 2");
                    break;
            }
        }
        return fileList;
    }

    //Code for composing an email
    public void composeEmail() throws ListOverflowException {
        String choice, fileName = null;
        Scanner keyboard= new Scanner(System.in);
        System.out.println("\nIn development");

        Email email = new Email();

        //Recipient
        email.setRecipient(insertRecipients());
        email.setSender("me");

        //Subject
        System.out.print("\nSubject: ");
        email.setSubject(keyboard.nextLine());

        //Body
        System.out.print("\nBody: ");
        email.setBody(keyboard.nextLine());

        //Attachments
        email.setAttachments(insertAttachments());

        //Checking content for debugging purposes (Can be removed later on)
        System.out.println("\n== Contents of the email added: ");
        System.out.println("Recipient(s): ");
        email.getRecipient().show();

        //Option to send, add to drafts, or cancel and delete the email
        System.out.println("Subject: " + email.getSubject());
        System.out.println("Body: " + email.getBody());
        System.out.println("Attachment(s): ");
        email.getAttachments().show();

        System.out.println("\n[1]Send");
        System.out.println("[2]Add to drafts");
        System.out.println("[3]Cancel (Delete email)");
        boolean add = true;
        while(add){
            System.out.print("Choice: ");
            switch(keyboard.nextLine()){
                case "1":
                    sent.insert(email);
                    System.out.println("\n== Email successfully sent! ==");
                    add = false;
                    break;
                case "2":
                    drafts.insert(email);
                    System.out.println("\n== Email successfully added to drafts! ==");
                    add = false;
                    break;
                case "3":
                    add = false;
                    break;
                default:
                    System.out.println("Please enter only 1, 2 or 3");
            }
        }

    }

    public Email selectEmail(DoublyLinkedList<Email> list){
        Email email = new Email();
        boolean selected = false;
        int input;
        do{
            System.out.println("\nInput number of email you want to select: ");
            System.out.println("[0] Go to main menu");
            input = getIntInput();
            if(input==0){
                return null;
            }
            if(input>list.getSize() || input<1){
                System.out.println("The number you entered does not correspond to a specific email");
            }else{
                System.out.println("[" + input + "] " + "Sender: " + list.getElementFromNumber(input).getSender() +
                        "\nSubject: " + list.getElementFromNumber(input).getSubject());
                System.out.println("\nYou selected email number " + input);
                email = list.getElementFromNumber(input);
                selected = true;
            }
        } while(!selected);
        return email;
    }
    //DONE
    public void open(DoublyLinkedList<Email> list, Email email){
        System.out.println("Email Details: ");
        System.out.println("============================================");
        System.out.println("Subject: " + list.getElement(email).getSubject());
        System.out.print("Recipient: "  );
        email.getRecipient().show();
        System.out.println("Sender: " + list.getElement(email).getSender());
        System.out.println("Body: " + list.getElement(email).getBody());
        System.out.println("Attachments: " );
        email.getAttachments().show();
        System.out.println("============================================");
        System.out.println("Email options");
    }

    public void deleteEmail(String list, Email email) throws ListOverflowException {
        switch(list){
            case "primary":
                primary.delete(email);
                trash.insert(email);
                break;
            case "social":
                social.delete(email);
                trash.insert(email);
                break;
            case "promotions":
                promotions.delete(email);
                trash.insert(email);
                break;
            case "drafts":
                drafts.delete(email);
                trash.insert(email);
                break;
            case "sent":
                sent.delete(email);
                trash.insert(email);
                break;
            case "starred":
                starred.delete(email);
                trash.insert(email);
                break;
            case "snoozed":
                snoozed.delete(email);
                trash.insert(email);
                break;
            case "spam":
                spam.delete(email);
                trash.insert(email);
                break;
            case "important":
                important.delete(email);
                trash.insert(email);
                break;
            case "trash":
                trash.delete(email);
                break;
        }
    }


    public void addToStarred(Email email) throws ListOverflowException { //removed parameter
        starred.insert(email);
        System.out.println("Email is added to Starred");
    }

    public void snooze(String listName, Email email) throws ListOverflowException {
        snoozed.insert(email);
        deleteEmail(listName,email);
        System.out.println("Email is snoozed");
    }

    public void markImportant(DoublyLinkedList<Email> list, Email email) throws ListOverflowException {
        list.insert(email);
        System.out.println("Email is marked important");
    }

    public void addToSpam(String listName, Email email) throws ListOverflowException {
        spam.insert(email);
        deleteEmail(listName,email);
        System.out.println("Email added to spam");
    }

    public void readSampleEmailsReceived() throws IOException, ListOverflowException {
        BufferedReader br = new BufferedReader(new FileReader("Files\\SampleEmailsReceived"));
        DoublyLinkedList<String> recipients = new DoublyLinkedList<>();
        DoublyLinkedList<File> attachments = new DoublyLinkedList<>();
        Email e;
        String line = br.readLine();
        String[] dataArr = new String[10];

        while(true) {
            line = br.readLine();
            recipients = new DoublyLinkedList<>();
            attachments = new DoublyLinkedList<>();
            if (line == null) {
                break;
            }
            dataArr = line.split(",");
            String r[] = dataArr[1].split("/"); //for getting the recipients and putting in a list
            for(int i = 0; i<r.length; i++){
                recipients.insert(r[i]);
            }
            String a[] = new String[50];
            if(dataArr[4].contains("/")) {
                a = dataArr[4].split("/");
                for(int i = 0; i<a.length; i++){
                    File att = new File(a[i]);
                    attachments.insert(att);
                }
            } else{
                attachments.insert(new File(dataArr[4]));
            }


            e = new Email(dataArr[0],recipients,dataArr[2],dataArr[3],attachments);
            if(dataArr[5].equalsIgnoreCase("primary")){
                primary.insert(e);
            }else if(dataArr[5].equalsIgnoreCase("social")){
                social.insert(e);
            } else if(dataArr[5].equalsIgnoreCase("promotions")){
                promotions.insert(e);
            }
        }
        br.close();
        inbox.insert(primary);
        inbox.insert(social);
        inbox.insert(promotions);
    }

}