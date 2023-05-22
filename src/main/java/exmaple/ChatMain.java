package exmaple;

import asyncSdk.Async;
import asyncSdk.AsyncConfig;

import chatSdk.chat.Chat;
import chatSdk.chat.ChatListener;
import chatSdk.dataTransferObject.GeneralRequest;
import chatSdk.dataTransferObject.chat.*;
import chatSdk.dataTransferObject.contacts.outPut.*;
import chatSdk.dataTransferObject.message.outPut.*;
import chatSdk.dataTransferObject.system.outPut.*;
import chatSdk.dataTransferObject.thread.inPut.Invitee;
import chatSdk.dataTransferObject.thread.outPut.*;
import chatSdk.dataTransferObject.user.outPut.*;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                .token("670d1b274a0244e1b553134f1ebb8066.XzIwMjM1")
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

    void addAuditor() {
        RoleRequest request = new RoleRequest();
        request.setUserId(3463768);
        request.setRoles(new ArrayList<String>() {{
            add(RoleType.POST_CHANNEL_MESSAGE);
            add(RoleType.READ_THREAD);
        }});
        ArrayList<RoleRequest> roleRequestArrayList = new ArrayList<>();
        roleRequestArrayList.add(request);
//        SetAuditorRequest request1 = new SetAuditorRequest
//                .Builder()
//                .setSubjectId(4026233l)
//                .setRoles(roleRequestArrayList)
//                .setMessageType(ChatMessageType.SET_ROLE_TO_USER)
//                .build();
//        chat.addAuditor2(request1);
    }


    public void getContact() {
        GetContactsRequest request = new GetContactsRequest
                .Builder()
                .build();
        chat.getContacts(request);
    }

    public void block() {
//        BlockRequest request = new BlockRequest
//                .Builder()
//                .setContactId(192707888l)
//                .build();
//        chat.block2(request);
        BlockRequest request = new BlockRequest
                .Builder()
                .setThreadId(3252552l)
                .build();
        chat.block(request);
    }

    public void unBlock() {
        UnBlockRequest request = new UnBlockRequest
                .Builder()
                .setContactId(192707888l)
                .build();
        chat.unBlock(request);
    }

    public void getBlockList2() {
        BlockListRequest request = new BlockListRequest
                .Builder()
                .build();
        chat.blockList(request);
    }

    public void clearHistory2() {
        ClearHistoryRequest request = new ClearHistoryRequest
                .Builder()
                .setThreadId(4049730l)
                .build();
        chat.clearHistory(request);
    }

    public void getHistory() {
        GetHistoryRequest h = new GetHistoryRequest
                .Builder()
                .setSubjectId(3252552l)
                .build();
        chat.getHistory(h);
    }

    public void leaveThread() {
        LeaveThreadRequest request = new LeaveThreadRequest
                .Builder()
                .setThreadId(4049730l)
                .setClearHistory(false)
                .build();
        chat.leaveThread(request);
    }

    public void editMessage() {
        EditMessageRequest request = new EditMessageRequest
                .Builder().setMessageContent("Mr Hamed Hosseini")
                .setSubjectId(709735935l)
                .setMessageId(21)
                .build();
        chat.editMessage(request);
    }

    public void sendMessage() {
        SendMessageRequest request = new SendMessageRequest
                .Builder()
                .setMessageType(1)
                .setThreadId(3252552l)
                .setMessage("Hello")
                .setSubjectId(3252552l)
                .build();
        chat.sendTextMessage(request);
    }

    public void getThreads() {
        GetThreadRequest req = new GetThreadRequest
                .Builder()
                .build();
        chat.getThreads(req);
    }

    public void forwardMessage() {
        ArrayList<Long> arr = new ArrayList<>(Arrays.asList(732957905l, 732958040l));
        ForwardMessageRequest request = new ForwardMessageRequest
                .Builder()
                .setMessageIds(arr)
                .setThreadId(4049730l)
                .build();
        chat.forwardMessage(request);
    }

    public void replyMessage() {
        ReplyMessageRequest request = new ReplyMessageRequest
                .Builder()
                .setMessage("good_morning")
                .setThreadId(3252552l)
                .setRepliedTo(735778335l)
                .build();
        chat.replyMessage(request);
    }

    public void createThread() {
        Invitee[] invitees = new Invitee[1];
        Invitee invitee = new Invitee();
        invitee.setIdType(InviteType.TO_BE_USER_CONTACT_ID);
        invitee.setId("192707888");
        invitees[0] = invitee;
        CreateThreadRequest request = new CreateThreadRequest
                .Builder()
                .setType(ThreadType.NORMAL)
                .setInvitees(Arrays.asList(invitees))
                .setTitle("sendMessage")
                .build();
        chat.createThread(request);
    }

    public void seenMessage() {
        SeenMessageListRequest request = new SeenMessageListRequest
                .Builder()
                .setMessageId(732957905l)
                .build();
        chat.seenMessageList(request);
    }

    public void getDeliveredList() {
        DeliveredMessageListRequest request = new DeliveredMessageListRequest
                .Builder()
                .setMessageId(732613721l)
                .build();
        chat.deliveredMessageList(request);
    }

    public void mute() {
        GeneralRequest request = new GeneralRequest
                .Builder().setSubjectId(3252552l)
                .setMessageType(ChatMessageType.MUTE_THREAD)
                .build();
        chat.muteThread(request);
    }

    public void unMute() {
        GeneralRequest request = new GeneralRequest
                .Builder()
                .setSubjectId(3252552l)
                .setMessageType(ChatMessageType.UN_MUTE_THREAD)
                .build();
        chat.unMuteThread(request);
    }

    public void pinThread() {
        GeneralRequest request = new GeneralRequest
                .Builder()
                .setSubjectId(3252552l)
                .setMessageType(ChatMessageType.PIN_THREAD)
                .build();
        chat.pinThread(request);
    }

    public void unPinThread() {
        GeneralRequest request = new GeneralRequest
                .Builder()
                .setSubjectId(3252552l)
                .setMessageType(ChatMessageType.UNPIN_THREAD)
                .build();
        chat.unPinThread(request);
    }

    public void removeParticipants() {
        List<Long> arr = new ArrayList<>(Arrays.asList(3463768l));
        RemoveParticipantsRequest request = new RemoveParticipantsRequest
                .Builder()
                .setParticipantIds(arr)
                .setThreadId(4026226l)
                .build();
        chat.removeParticipants(request);
    }

    public void getParticipant() {
        ThreadParticipantRequest request = new ThreadParticipantRequest
                .Builder()
                .setSubjectId(3252552l)
                .build();
        chat.getThreadParticipants(request);
    }

    public void addParticipants() {
        List<Long> arr = new ArrayList<>(Arrays.asList(192707888l, 246634476l));
        AddParticipantsRequest request = new AddParticipantsRequest
                .Builder()
                .setContactIds(arr)
                .setThreadId(4026226)
                .build();
        chat.addParticipants(request);
    }

    public void getUserinfo() {
        GeneralRequest request = new GeneralRequest
                .Builder()
                .setMessageType(ChatMessageType.USER_INFO)
                .build();
        chat.getUserInfo(request);
    }

    public void closeThread2() {
        GeneralRequest request = new GeneralRequest
                .Builder()
                .setSubjectId(4026226l)
//                .setMessageType(ChatMessageType.CLOSE_THREAD)
                .build();
        chat.closeThread(request);
    }

    public void pinMessage() {
        PinMessageRequest request = new PinMessageRequest
                .Builder()
                .setMessageId(732613721l)
                .setNotifyAll(false)
                .build();
        chat.pinMessage(request);
    }

    public void deliveryMessage() {
        DeliveryMessageRequest request = new DeliveryMessageRequest
                .Builder()
                .setMessageId(736407173)
                .setThreadId(3252552)
                .build();
        chat.deliveryMessage(request);
    }

    public void unReadMessageCount() {
        AllUnReadMessageCountRequest request = new AllUnReadMessageCountRequest
                .Builder()
                .setCountMutedThreads(false)
                .build();
        chat.unReadMessageCount(request);
    }
    public void signalMessage() {
        SignalMessageRequest request = new SignalMessageRequest
                .Builder()
                .setThreadId(3252552l)
                .setType(SignalMessageType.isTyping)
                .build();
        chat.signalMessage(request);
    }

    public void currentUserRoles() {
        GeneralRequest request = new GeneralRequest
                .Builder()
                .setMessageType(ChatMessageType.GET_CURRENT_USER_ROLES)
                .setSubjectId(4026226l)
                .build();
        chat.currentUserRoles(request);
    }
}
