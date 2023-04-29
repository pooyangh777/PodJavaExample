package exmaple;

import asyncSdk.Async;
import asyncSdk.AsyncConfig;

import chatSdk.chat.Chat;
import chatSdk.chat.ChatListener;
import chatSdk.dataTransferObject.ChatResponse;
import chatSdk.dataTransferObject.chat.*;
import chatSdk.dataTransferObject.contacts.inPut.RequestSearchContact;
import chatSdk.dataTransferObject.contacts.outPut.*;
import chatSdk.dataTransferObject.file.outPut.RequestFileMessage;
import chatSdk.dataTransferObject.file.outPut.RequestReplyFileMessage;
import chatSdk.dataTransferObject.file.outPut.RequestUploadFile;
import chatSdk.dataTransferObject.file.outPut.RequestUploadImage;
import chatSdk.dataTransferObject.message.inPut.ResultNewMessage;
import chatSdk.dataTransferObject.message.outPut.*;
import chatSdk.dataTransferObject.system.outPut.*;
import chatSdk.dataTransferObject.thread.inPut.Invitee;
import chatSdk.dataTransferObject.thread.outPut.*;
import chatSdk.dataTransferObject.user.inPut.ResultHistory;
import chatSdk.dataTransferObject.user.outPut.*;
import chatSdk.mainmodel.RequestThreadInnerMessage;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Created By Khojasteh on 7/27/2019
 */
public class ChatMain implements ChatListener {
    public static String platformHost = "https://sandbox.pod.ir:8043";
    public static String socketAddress = "wss://msg.pod.ir/ws";
    public static String token = "90c2a567ec85476dad8defc550371ea9.XzIwMjM0";
    //    "63b9aa126f814222bec6004663de3cc9"
    public static String ssoHost = "http://172.16.110.235";
    public static String fileServer = "https://core.pod.ir";
    public static String serverName = "chatlocal";
    public static String socketServerName = "chat-server";
    public static String queueServer = "192.168.112.23";
    public static String queuePort = "61616";
    public static String queueInput = "queue-in-chat-dotnet-local";
    public static String queueOutput = "queue-out-chat-dotnet-local";
    public static String queueUserName = "root";
    public static String queuePassword = "j]Bm0RU8gLhbPUG";
    public static Long chatId = 4101L;

    //    public static String platformHost = "https://sandbox.pod.ir:8043";
//    public static String token = "34ec42af289e40398c1c05e40446845b";
//    public static String ssoHost = "https://accounts.pod.ir";
//    public static String fileServer = "https://core.pod.ir";
//    public static String serverName = "chat-server";
//    public static String queueServer = "10.56.16.25";
//    public static String queuePort = "61616";
//    public static String queueInput = "queue-in-amjadi-stomp";
//    public static String queueOutput = "queue-out-amjadi-stomp";
//    public static String queueUserName = "root";
//    public static String queuePassword = "zalzalak";
//    public static Long chatId = 4101L;

    static Chat chat;


    private static Logger logger = LogManager.getLogger(Async.class);
    Gson gson = new Gson();

    void init() {
        boolean isSocket = true;
        String serverName = isSocket ? socketServerName : this.serverName;
        AsyncConfig asyncConfig = AsyncConfig
                .builder()
                .isSocketProvider(isSocket)
                .socketAddress(socketAddress)
                .serverName(serverName)
                .queuePassword(queuePassword)
                .queueUserName(queueUserName)
                .queueInput(queueInput)
                .queueOutput(queueOutput)
                .queueServer(queueServer)
                .queuePort(queuePort)
                .isLoggable(true)
                .appId("PodChat")
                .build();
        ChatConfig chatConfig = ChatConfig.builder()
                .asyncConfig(asyncConfig)
                .severName(serverName)
                .token("c32128a2d14045db8128f4f113128919.XzIwMjM0")
//        "84831a17a1f94f4683b783470ae21d41.XzIwMjIxMg"
                .chatId(chatId)
                .fileServer(fileServer)
                .ssoHost(ssoHost)
                .platformHost(platformHost)
                .isLoggable(true)
                .build();
        try {
            chat = Chat.init(chatConfig, this);
            chat.connect();
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onError(String s, ErrorOutPut errorOutPut) {

    }

    /*********************************************************************
     *                             ADMIN                                 *
     *********************************************************************/

    @Override
    public void onChatState(ChatState state) {
        System.out.println(state);
    }

    @Override
    public void OnLogEvent(String s) {

    }

    /**
     * set role
     */


    public void addAdmin() {
        RequestRole requestRole = new RequestRole();
        requestRole.setId(4781);
        requestRole.setRoleTypes(new ArrayList<String>() {{
            add(RoleType.THREAD_ADMIN);
        }});


        ArrayList<RequestRole> requestRoleArrayList = new ArrayList<>();
        requestRoleArrayList.add(requestRole);

        RequestSetAdmin requestSetAdmin = new RequestSetAdmin
                .Builder(5941, requestRoleArrayList)
                .build();

        chat.addAdmin(requestSetAdmin);

    }

    void addAuditor() {
        RequestRole requestRole = new RequestRole();
        requestRole.setId(1181);
        requestRole.setRoleTypes(new ArrayList<String>() {{
            add(RoleType.POST_CHANNEL_MESSAGE);
            add(RoleType.READ_THREAD);
        }});

        ArrayList<RequestRole> requestRoleArrayList = new ArrayList<>();
        requestRoleArrayList.add(requestRole);

        RequestSetAuditor requestSetAuditor = new RequestSetAuditor
                .Builder(5461, requestRoleArrayList)
                .build();

        chat.addAuditor(requestSetAuditor);

    }

    /**
     * delete role
     */
    void removeAdmin() {
        RequestRole requestRole = new RequestRole();
        requestRole.setId(4781);
        requestRole.setRoleTypes(new ArrayList<String>() {{
            add(RoleType.THREAD_ADMIN);
        }});

        ArrayList<RequestRole> requestRoleArrayList = new ArrayList<>();
        requestRoleArrayList.add(requestRole);

        RequestSetAdmin requestSetAdmin = new RequestSetAdmin
                .Builder(5941, requestRoleArrayList)
                .build();

        chat.removeAdmin(requestSetAdmin);

    }


    void removeAuditor() {
        RequestRole requestRole = new RequestRole();
        requestRole.setId(1181);
        requestRole.setRoleTypes(new ArrayList<String>() {{
            add(RoleType.POST_CHANNEL_MESSAGE);
            add(RoleType.READ_THREAD);
        }});

        ArrayList<RequestRole> requestRoleArrayList = new ArrayList<>();
        requestRoleArrayList.add(requestRole);

        RequestSetAuditor requestSetAuditor = new RequestSetAuditor
                .Builder(5461, requestRoleArrayList)
                .build();


        chat.removeAuditor(requestSetAuditor);

    }


    void getAdmin() {
        RequestGetAdmin requestGetAdmin = new RequestGetAdmin
                .Builder(5941)
                .build();

        chat.getAdminList(requestGetAdmin);
    }

    /******************************************************************
     *                           CONTACT                              *
     * ****************************************************************/

    /**
     * add contact
     */
    void addContact() {
        RequestAddContact requestAddContact = new RequestAddContact
                .Builder()
                .cellphoneNumber("09359684661")
                .lastName("شادی")
                .build();
        chat.addContact(requestAddContact);
    }

    /**
     * remove contact
     */
    private void removeContact() {
        RequestRemoveContact requestRemoveContact = new RequestRemoveContact
                .Builder(20714)
                .build();

        chat.removeContact(requestRemoveContact);
    }

    /**
     * update contact
     */
    private void updateContact() {
        RequestUpdateContact requestUpdateContact = new RequestUpdateContact
                .Builder(13882, "زهرا", "مظلوم", "09156452709", "zahra@gmail.com")
                .build();

        chat.updateContact(requestUpdateContact);
    }

    /**
     * search contact
     */
    private void searchContact() {
        RequestSearchContact searchContact = new RequestSearchContact
                .Builder()
                .cellphoneNumber("09156452709")
                .build();

        chat.searchContact(searchContact);
    }

    /**
     * get contact
     */
    private void getcontact() {
        RequestGetContact requestGetContact = new RequestGetContact
                .Builder()
                .build();
        chat.getContacts(requestGetContact);
    }

    /**
     * block
     */
    private void block() {
        RequestBlock requestBlock = new RequestBlock
                .Builder()
                .contactId(13882)
                .build();

        chat.block(requestBlock);
    }

    /**
     * unblock
     */
    private void unblock() {
        RequestUnBlock requestUnBlock = new RequestUnBlock
                .Builder()
//                (6061)
                .blockId(2041)
                .build();

        chat.unblock(requestUnBlock);
    }

    /**
     * block list
     */
    private void getBlockList() {
        RequestBlockList requestBlockList = new RequestBlockList
                .Builder()
                .build();

        chat.getBlockList(requestBlockList);
    }
    /******************************************************************
     *                           HISTORY                              *
     * ****************************************************************/

    /**
     * clear history
     */
    private void clearHistory() {
        RequestClearHistory requestClearHistory = new RequestClearHistory
                .Builder(5461)
                .build();

        chat.clearHistory(requestClearHistory);
    }

    /**
     * get history
     */
    private void getHistory() {
    /*    RequestGetHistory requestGetHistory = new RequestGetHistory
                .Builder(5461)
                .build();

        chatController.getHistory(requestGetHistory);*/
        RequestGetHistory requestGetHistory2 = new RequestGetHistory
                .Builder(5461)
//                .uniqueIds(new String[]{"a98d00af-6cb7-4174-a82a-a8ec68af0bb1"})
                .build();

        chat.getHistory(requestGetHistory2);

     /*   RequestGetHistory requestGetHistory1 = new RequestGetHistory
                .Builder(5461)
                .build();

        chatController.getHistory(requestGetHistory1, null);*/
    }

    public void getHistory2() {
        GetHistoryRequest h = new GetHistoryRequest
                .Builder()
                .setSubjectId(3252552l)
                .build();
        chat.getHistory2(h);
    }

    /******************************************************************
     *                           THREAD                               *
     * ****************************************************************/

    /**
     * leave thread
     */
    private void leaveThread() {
        RequestLeaveThread leaveThread = new RequestLeaveThread
                .Builder(5941)
                .build();

        chat.leaveThread(leaveThread);
    }

    /**
     * delete message
     */
    private void deleteMessage() {
        RequestDeleteMessage deleteMessage = new RequestDeleteMessage
                .Builder(new ArrayList<Long>() {{
            add(72301L);
        }})
                .build();

        chat.deleteMessage(deleteMessage);
    }

    /**
     * create thread with message
     */
    private void createThreadWithMessage() {
        RequestThreadInnerMessage requestThreadInnerMessage = new RequestThreadInnerMessage
                .Builder()
                .message("hello world")
                .build();

        Invitee invitee = new Invitee();
        invitee.setId("09900449643");
        invitee.setIdType(InviteType.TO_BE_USER_CELLPHONE_NUMBER);

//        Invitee invitee1 = new Invitee();
//        invitee1.setId(1181);
//        invitee1.setIdType(InviteType.TO_BE_USER_ID);

        RequestCreateThreadWithMessage requestCreateThreadWithMessage = new RequestCreateThreadWithMessage
                .Builder(ThreadType.NORMAL, new ArrayList<Invitee>() {{
            add(invitee);
        }})
                .message(requestThreadInnerMessage)
                .build();
        chat.createThreadWithMessage(requestCreateThreadWithMessage);

    }

    /**
     * create thread with file message
     */

    private void createThreadWithFileMessage() {
        RequestUploadImage requestUploadFile = new RequestUploadImage
                .Builder("D:\\download.jpg")
                .hC(200)
                .build();

        Invitee invitee = new Invitee();
        invitee.setId("09900449643");
        invitee.setIdType(InviteType.TO_BE_USER_CELLPHONE_NUMBER);

        RequestThreadInnerMessage requestThreadInnerMessage = new RequestThreadInnerMessage
                .Builder()
                .message("hellllllllllllllo")
                .build();


        RequestCreateThreadWithFile requestCreateThreadWithFile = new RequestCreateThreadWithFile
                .Builder(ThreadType.NORMAL, new ArrayList<Invitee>() {{
            add(invitee);
        }}, requestUploadFile)
                .message(requestThreadInnerMessage)
                .description("tesssssssssssst")
                .build();


        chat.createThreadWithFileMessage(requestCreateThreadWithFile);

    }

    /**
     * edit message
     */
    private void editMessage() {
        RequestEditMessage requestEditMessage = new RequestEditMessage
                .Builder("hiii", 72301)
                .build();
        chat.editMessage(requestEditMessage);
    }

    /**
     * send message
     */
    private void sendMessage() {
        RequestMessage requestThread = new RequestMessage
                .Builder("seen list", 5701)
                .build();

        chat.sendTextMessage(requestThread);
    }

    public void sendMessage2() {
        SendMessageRequest request = new SendMessageRequest
                .Builder()
                .setMessageType(1)
                .setThreadId(3252552l)
                .setMessage("Hello")
                .setSubjectId(3252552l)
                .build();
        chat.sendTextMessage2(request);
    }

    /**
     * get thread
     */
//    public void getThreads() {
//        RequestThread requestThread = new RequestThread
//                .Builder()
//                .build();
//        chat.getThreads(requestThread);
//    }
    public void getThreads() {
        GetThreadRequest req = new GetThreadRequest
                .Builder()
                .build();
        chat.getThreads(req);
    }

    /**
     * delete multiple message
     */
    private void deleteMultipleMessage() {
        RequestDeleteMessage requestDeleteMessage = new RequestDeleteMessage
                .Builder(new ArrayList<Long>() {{
            add(56242L);
            add(56241L);
        }})
                .deleteForAll(true)
                .build();

        chat.deleteMultipleMessage(requestDeleteMessage);
    }

    /**
     * forward message
     */
    private void forwardMessage() {
        RequestForwardMessage forwardMessage = new RequestForwardMessage
                .Builder(6362, new ArrayList<Long>() {{
            add(72301L);
        }})
                .build();

        chat.forwardMessage(forwardMessage);
    }

    /**
     * reply message
     */
    private void replyMessage() {
        RequestReplyMessage requestReplyMessage = new RequestReplyMessage
                .Builder("hi", 6362, 72301)
                .build();

        chat.replyMessage(requestReplyMessage);
    }

    /**
     * create thread
     */
    private void createThread() {
       /* Invitee[] invitees = new Invitee[2];
        Invitee invitee = new Invitee();
        invitee.setIdType(InviteType.TO_BE_USER_CONTACT_ID);
        invitee.setId(13812);

        Invitee invitee1 = new Invitee();
        invitee1.setIdType(InviteType.TO_BE_USER_CONTACT_ID);
        invitee1.setId(13882);

        invitees[0] = invitee;
        invitees[1] = invitee1;

        chatController.createThread(ThreadType.PUBLIC_GROUP, invitees, "sendMessage", "", "", "");*/

        Invitee[] invitees = new Invitee[1];
        Invitee invitee = new Invitee();
        invitee.setIdType(InviteType.TO_BE_USER_CONTACT_ID);
        invitee.setId("13812");

//        Invitee invitee2 = new Invitee();
//        invitee2.setIdType(InviteType.TO_BE_USER_CONTACT_ID);
//        invitee2.setId(13812);

        invitees[0] = invitee;
//        invitees[1] = invitee2;

        chat.createThread(ThreadType.NORMAL, invitees, "sendMessage", "", "", "", "default");
    }

    /**
     * seen message list
     */
    private void getSeenList() {
        RequestSeenMessageList requestSeenMessageList = new RequestSeenMessageList
                .Builder(55216)
                .build();

        chat.getMessageSeenList(requestSeenMessageList);
    }

    /**
     * delivery message list
     */
    private void getDeliveryList() {
        RequestDeliveredMessageList requestDeliveredMessageList = new RequestDeliveredMessageList
                .Builder(55216)
                .build();

        chat.getMessageDeliveredList(requestDeliveredMessageList);
    }

    /**
     * mute thread
     */
    private void mute() {
        RequestMuteThread requestMuteThread = new RequestMuteThread
                .Builder(4982)
                .build();

        chat.muteThread(requestMuteThread);
    }

    /**
     * unmute thread
     */
    private void unmute() {
        RequestMuteThread requestMuteThread = new RequestMuteThread
                .Builder(4982)
                .build();

        chat.unMuteThread(requestMuteThread);
    }

    /**
     * spam thread
     */

    private void spam() {
        RequestSpam requestSpam = new RequestSpam
                .Builder(6450)
                .build();

        chat.spam(requestSpam);
    }


    /**
     * bot message
     */

    private void interactiveMessage() {
        RequestInteract requestInteract = new RequestInteract
                .Builder(56249, "OK")
                .build();

        chat.interactMessage(requestInteract);
    }


    private void pinThread() {
        RequestPinThread requestPinThread = new RequestPinThread
                .Builder(5461)
                .build();

        chat.pinThread(requestPinThread);
    }

    private void unPinThread() {
        RequestPinThread requestPinThread = new RequestPinThread
                .Builder(5461)
                .build();

        chat.unPinThread(requestPinThread);
    }


    /******************************************************************
     *                           PARTICIPANT                          *
     * ****************************************************************/

    /**
     * remove participant
     */
    private void removeParticipant() {
        RequestRemoveParticipants requestRemoveParticipants = new RequestRemoveParticipants
                .Builder(5941, new ArrayList<Long>() {{
            add(1181L);
        }})
                .build();

        chat.removeParticipants(requestRemoveParticipants);
    }

    /**
     * get participant
     */
    private void getParticipant() {
        RequestThreadParticipant threadParticipant = new RequestThreadParticipant
                .Builder(5941)
                .build();

        chat.getThreadParticipants(threadParticipant);
    }

    /**
     * add participant
     */
    private void addParticipant() {
        RequestAddParticipants addParticipants = new RequestAddParticipants
                .Builder(5941, new ArrayList<Long>() {{
            add(13812L);
        }})
                .build();

        chat.addParticipants(addParticipants);
    }

    /******************************************************************
     *                           FIlE                                 *
     * ****************************************************************/

    /**
     * send file message
     */
    private void sendFileMessage() {
        RequestFileMessage requestFileMessage = new RequestFileMessage
                .Builder(5461, "C:\\Users\\fanap-10\\Pictures\\Saved Pictures\\a.jpg")
                .description("this is test image")
                .xC(0)
                .yC(0)
                .hC(100)
                .wC(200)
                .build();

        chat.sendFileMessage(requestFileMessage, null);
    }

    /**
     * reply file message
     */
    private void replyFileMessage() {
  /*      RequestReplyFileMessage requestReplyFileMessage = new RequestReplyFileMessage
                .Builder("this is test", 5461, 47921, "C:\\Users\\fanap-10\\Pictures\\Saved Pictures\\a.jpg")
                .xC(0)
                .yC(0)
                .hC(100)
                .wC(200)
                .build();*/


        RequestReplyFileMessage requestReplyFileMessage = new RequestReplyFileMessage
                .Builder("this is test", 5461, 55202, "C:\\Users\\fanap_soft\\Desktop\\chat output\\b.jpg")
                .xC(0)
                .yC(0)
                .hC(100)
                .wC(200)
                .build();
        chat.replyFileMessage(requestReplyFileMessage, null);
    }

    /**
     * upload image
     */

    private void uploadImage() {
        RequestUploadImage requestUploadImage = new RequestUploadImage
                .Builder("D:\\download.jpg")
                .build();
        System.out.println(gson.toJson(requestUploadImage));
        chat.uploadImage(requestUploadImage);
    }

    /**
     * upload file
     */
    private void uploadFile() {
        RequestUploadFile requestUploadFile = new RequestUploadFile
                .Builder("D:\\Music.rar")
                .build();
        chat.uploadFile(requestUploadFile);
    }

    @Override
    public void onNewMessage(String content, ChatResponse<ResultNewMessage> response) {
        ChatListener.super.onNewMessage(content, response);
    }

    @Override
    public void onGetHistory(String content, ChatResponse<ResultHistory> history) {
        ChatListener.super.onGetHistory(content, history);
    }
}
