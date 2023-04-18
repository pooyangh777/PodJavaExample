//package exmaple;
//import chatSdk.chat.Chat;
//import chatSdk.chat.ProgressHandler;
//
//import chatSdk.dataTransferObject.ChatResponse;
//import chatSdk.dataTransferObject.chat.ChatConfig;
//import chatSdk.dataTransferObject.chat.ChatState;
//import chatSdk.dataTransferObject.file.outPut.*;
//import chatSdk.dataTransferObject.map.outPut.*;
//import chatSdk.dataTransferObject.message.outPut.*;
//import chatSdk.dataTransferObject.thread.outPut.*;
//import chatSdk.dataTransferObject.user.outPut.*;
//import chatSdk.dataTransferObject.contacts.outPut.*;
//import chatSdk.dataTransferObject.system.outPut.*;
//import chatSdk.dataTransferObject.system.inPut.*;
//import chatSdk.dataTransferObject.thread.inPut.*;
//import chatSdk.dataTransferObject.message.inPut.*;
//import chatSdk.dataTransferObject.file.inPut.*;
//import chatSdk.dataTransferObject.user.inPut.*;
//import chatSdk.dataTransferObject.contacts.inPut.*;
//
//import chatSdk.mainmodel.*;
//
//import com.google.gson.Gson;
//import chatSdk.chat.ChatListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created By Khojasteh on 7/30/2019
// */
//public class ChatController implements ChatListener {
//
//    private Chat chat;
//    private ChatContract.view view;
//
//    public ChatController(ChatContract.view view, ChatConfig chatConfig) {
//        chat = Chat.init(chatConfig, this);
//        this.view = view;
//    }
//
//    @Override
//    public void isDatabaseOpen() {
//
//    }
//
//    @Override
//    public void uploadImage(RequestUploadImage requestUploadImage) {
//        chat.uploadImage(requestUploadImage);
//    }
//
//    @Override
//    public void uploadFileMessage(RequestFileMessage requestFileMessage, ProgressHandler.sendFileMessage handler) {
//        chat.sendFileMessage(requestFileMessage, handler);
//    }
//
//    @Override
//    public void replyFileMessage(RequestReplyFileMessage requestReplyFileMessage, ProgressHandler.sendFileMessage handler) {
//        chat.replyFileMessage(requestReplyFileMessage, handler);
//    }
//
//
//    @Override
//    public void uploadFile(RequestUploadFile requestUploadFile) {
//        chat.uploadFile(requestUploadFile);
//    }
//
//
//    @Override
//    public void resendMessage(String uniqueId) {
//
//    }
//
//    @Override
//    public void cancelMessage(String uniqueId) {
//
//    }
//
//    @Override
//    public void retryUpload(String uniqueId) {
//
//    }
//
//    @Override
//    public void cancelUpload(String uniqueId) {
//
//    }
//
//    @Override
//    public void seenMessageList(RequestSeenMessageList requestParam) {
//        chat.getMessageSeenList(requestParam);
//    }
//
//    @Override
//    public void deliveredMessageList(RequestDeliveredMessageList requestParams) {
//        chat.getMessageDeliveredList(requestParams);
//    }
//
//    @Override
//    public void createThreadWithMessage(RequestCreateThreadWithMessage threadRequest) {
//        chat.createThreadWithMessage(threadRequest);
//    }
//
//    @Override
//    public void getThreads(RequestThread requestThread) {
//        chat.getThreads(requestThread);
//    }
//
//    @Override
//    public void getThreads(Integer count, Long offset, ArrayList<Integer> threadIds, String threadName,
//                           long creatorCoreUserId, long partnerCoreUserId, long partnerCoreContactId, String typeCode) {
//        chat.getThreads(count, offset, threadIds, threadName, creatorCoreUserId, partnerCoreUserId, partnerCoreContactId
//                , typeCode);
//    }
//
//    @Override
//    public void getThreads(Integer count, Long offset, ArrayList<Integer> threadIds, String threadName) {
//
//    }
//
//    @Override
//    public void setToke(String token) {
//        chat.config.setToken(token);
//    }
//
//    @Override
//    public void connect() throws Exception {
//        chat.connect();
//    }
//
//    @Override
//    public void mapSearch(String searchTerm, Double latitude, Double longitude) {
//
//    }
//
//    @Override
//    public void mapRouting(String origin, String destination) {
//
//    }
//
//    @Override
//    public void mapStaticImage(RequestMapStaticImage request) {
//
//    }
//
//    @Override
//    public void mapReverse(RequestMapReverse request) {
//
//    }
//
//    @Override
//    public void getUserInfo() {
//        chat.getUserInfo();
//    }
//
//    @Override
//    public void getHistory(History history, long threadId) {
//
//    }
//
//    @Override
//    public void getHistory(RequestGetHistory request) {
//        chat.getHistory(request);
//    }
//
//    @Override
//    public void searchHistory(NosqlListMessageCriteriaVO messageCriteriaVO) {
//
//    }
//
//    @Override
//    public void getContact(Integer count, Long offset, String typeCode) {
//        chat.getContacts(count, offset, typeCode);
//
//    }
//
//    @Override
//    public void getContact(RequestGetContact request) {
//        chat.getContacts(request);
//    }
//
//    @Override
//    public void createThread(int threadType, Invitee[] invitee, String threadTitle, String description, String image, String metaData, String typeCode) {
//        chat.createThread(threadType, invitee, threadTitle, description, image, metaData, typeCode);
//    }
//
//    @Override
//    public void createThread(RequestCreateThread requestCreateThread) {
//        chat.createThread(requestCreateThread);
//    }
//
//    @Override
//    public void createThreadWithFileMessage(RequestCreateThreadWithFile requestCreateThreadWithMessage) {
//        chat.createThreadWithFileMessage(requestCreateThreadWithMessage);
//    }
//
//    @Override
//    public void sendTextMessage(String textMessage, long threadId, Integer messageType, String metaData, String typeCode) {
//        chat.sendTextMessage(textMessage, threadId, messageType, metaData, typeCode);
//    }
//
//    @Override
//    public void sendTextMessage(RequestMessage requestMessage) {
//        chat.sendTextMessage(requestMessage);
//    }
//
//    @Override
//    public void replyMessage(String messageContent, long threadId, long messageId, String systemMetaData,
//                             Integer messageType, String typeCode) {
//        chat.replyMessage(messageContent, threadId, messageId, systemMetaData, messageType, typeCode);
//    }
//
//
//    @Override
//    public void replyMessage(RequestReplyMessage request) {
//        chat.replyMessage(request);
//    }
//
//    @Override
//    public void muteThread(int threadId) {
//
//    }
//
//    @Override
//    public void muteThread(RequestMuteThread requestMuteThread) {
//        chat.muteThread(requestMuteThread);
//    }
//
//    @Override
//    public void renameThread(long threadId, String title) {
//
//    }
//
//    @Override
//    public void unMuteThread(int threadId) {
//
//    }
//
//    @Override
//    public void unMuteThread(RequestMuteThread requestMuteThread) {
//        chat.unMuteThread(requestMuteThread);
//    }
//
//    @Override
//    public void editMessage(int messageId, String messageContent, String metaData) {
//        chat.editMessage(messageId, messageContent, metaData);
//    }
//
//    @Override
//    public void editMessage(RequestEditMessage request) {
//        chat.editMessage(request);
//    }
//
//
//    @Override
//    public void getThreadParticipant(int count, Long offset, long threadId) {
//
//    }
//
//    @Override
//    public void getThreadParticipant(RequestThreadParticipant request) {
//        chat.getThreadParticipants(request);
//    }
//
//    @Override
//    public void get(int count, Long offset, long threadId) {
//
//    }
//
//    @Override
//    public void addContact(String firstName, String lastName, String cellphoneNumber, String email, String typeCode) {
//        chat.addContact(firstName, lastName, cellphoneNumber, email, typeCode);
//    }
//
//    @Override
//    public void addContact(RequestAddContact request) {
//        chat.addContact(request);
//    }
//
//    @Override
//    public void removeContact(RequestRemoveContact requestRemoveContact) {
//        chat.removeContact(requestRemoveContact);
//    }
//
//    @Override
//    public void searchContact(RequestSearchContact requestSearchContact) {
//        chat.searchContact(requestSearchContact);
//    }
//
//    @Override
//    public void block(Long contactId, Long userId, Long threadId) {
//
//    }
//
//    @Override
//    public void block(RequestBlock request) {
//        chat.block(request);
//    }
//
//
//    @Override
//    public void unBlock(Long blockId, Long userId, Long threadId, Long contactId) {
//
//    }
//
//    @Override
//    public void unBlock(RequestUnBlock request) {
//        chat.unblock(request);
//    }
//
//    @Override
//    public void spam(long threadId) {
//
//    }
//
//    @Override
//    public void spam(RequestSpam requestSpam) {
//        chat.spam(requestSpam);
//    }
//
//    @Override
//    public void getBlockList(Long count, Long offset) {
//
//    }
//
//    @Override
//    public void forwardMessage(long threadId, ArrayList<Long> messageIds) {
//
//    }
//
//    @Override
//    public void forwardMessage(RequestForwardMessage request) {
//        chat.forwardMessage(request);
//    }
//
//    @Override
//    public void updateContact(RequestUpdateContact updateContact) {
//        chat.updateContact(updateContact);
//    }
//
//    @Override
//    public void seenMessage(long messageId, long ownerId) {
//        chat.seenMessage(messageId, ownerId);
//    }
//
//    @Override
//    public void logOut() {
//
//    }
//
//    @Override
//    public void removeParticipants(long threadId, List<Long> participantIds) {
//
//    }
//
//    @Override
//    public void removeParticipants(RequestRemoveParticipants requestRemoveParticipants) {
//        chat.removeParticipants(requestRemoveParticipants);
//    }
//
//    @Override
//    public void addParticipants(long threadId, List<Long> contactIds) {
//        chat.addParticipants(threadId, contactIds);
//    }
//
//    @Override
//    public void addParticipants(RequestAddParticipants requestAddParticipants) {
//        chat.addParticipants(requestAddParticipants);
//    }
//
//    @Override
//    public void leaveThread(long threadId) {
//
//    }
//
//    @Override
//    public void leaveThread(RequestLeaveThread requestLeaveThread) {
//        chat.leaveThread(requestLeaveThread);
//    }
//
//    @Override
//    public void updateThreadInfo(long threadId, ThreadInfoVO threadInfoVO) {
//
//    }
//
//    @Override
//    public void updateThreadInfo(RequestThreadInfo request) {
//
//    }
//
//    @Override
//    public void deleteMessage(RequestDeleteMessage deleteMessage) {
//        chat.deleteMessage(deleteMessage);
//    }
//
//    @Override
//    public void deleteMultipleMessage(RequestDeleteMessage deleteMessage) {
//        chat.deleteMultipleMessage(deleteMessage);
//    }
//
//    @Override
//    public void addAdmin(RequestSetAdmin requestSetAdmin) {
//        chat.addAdmin(requestSetAdmin);
//    }
//
//    @Override
//    public void removeAdmin(RequestSetAdmin requestSetAdmin) {
//        chat.removeAdmin(requestSetAdmin);
//    }
//
//    @Override
//    public void addAuditor(RequestSetAuditor requestSetAuditor) {
//        chat.addAuditor(requestSetAuditor);
//    }
//
//    @Override
//    public void removeAuditor(RequestSetAuditor requestSetAuditor) {
//        chat.removeAuditor(requestSetAuditor);
//    }
//
//
//    @Override
//    public void clearHistory(RequestClearHistory requestClearHistory) {
//        chat.clearHistory(requestClearHistory);
//    }
//
//    @Override
//    public void getAdminList(RequestGetAdmin requestGetAdmin) {
//        chat.getAdminList(requestGetAdmin);
//    }
//
//    @Override
//    public String startSignalMessage(RequestSignalMsg requestSignalMsg) {
//        return null;
//    }
//
//    @Override
//    public void stopSignalMessage(String uniqueId) {
//
//    }
//
//    @Override
//    public void getBlockList(RequestBlockList request) {
//        chat.getBlockList(request);
//    }
//
//    @Override
//    public void interactiveMessage(RequestInteract request) {
//        chat.interactMessage(request);
//    }
//
//    @Override
//    public void pin(RequestPinThread request) {
//        chat.pinThread(request);
//    }
//
//    @Override
//    public void unPin(RequestPinThread request) {
//        chat.unPinThread(request);
//    }
//
//
//    //View
//    @Override
//    public void onDeliver(String content, ChatResponse<ResultMessage> chatResponse) {
//        view.onGetDeliverMessage(chatResponse);
//    }
//
//    @Override
//    public void onGetThread(String content, ChatResponse<ResultThreads> thread) {
//        view.onGetThreadList(thread);
//    }
//
//    @Override
//    public void onThreadInfoUpdated(String content, ChatResponse<ResultThread> response) {
//    }
//
//    @Override
//    public void onGetContacts(String content, ChatResponse<ResultContact> outPutContact) {
//        view.onGetContacts(outPutContact);
//    }
//
//    @Override
//    public void onSeen(String content, ChatResponse<ResultMessage> chatResponse) {
//        view.onGetSeenMessage(chatResponse);
//    }
//
//    @Override
//    public void onSent(String content, ChatResponse<ResultMessage> chatResponse) {
//        view.onSentMessage(chatResponse);
//    }
//
//
//    @Override
//    public void onCreateThread(String content, ChatResponse<ResultThread> outPutThread) {
//        view.onCreateThread(outPutThread);
//    }
//
//    @Override
//    public void onGetThreadParticipant(String content, ChatResponse<ResultParticipant> outPutParticipant) {
//        view.onGetThreadParticipant(outPutParticipant);
//    }
//
//    @Override
//    public void onEditedMessage(String content, ChatResponse<ResultNewMessage> chatResponse) {
//        view.onEditMessage(chatResponse);
//    }
//
//    @Override
//    public void onGetHistory(String content, ChatResponse<ResultHistory> history) {
//        view.onGetThreadHistory(history);
//    }
//
//    @Override
//    public void onMuteThread(String content, ChatResponse<ResultMute> outPutMute) {
//        view.onMuteThread(outPutMute);
//    }
//
//    @Override
//    public void onUnmuteThread(String content, ChatResponse<ResultMute> outPutMute) {
//        view.onUnMuteThread(outPutMute);
//    }
//
//    @Override
//    public void onRenameThread(String content, OutPutThread outPutThread) {
//        view.onRenameGroupThread();
//    }
//
//    @Override
//    public void onContactAdded(String content, ChatResponse<ResultAddContact> chatResponse) {
//        view.onAddContact(chatResponse);
//    }
//
//    @Override
//    public void onUpdateContact(String content, ChatResponse<ResultUpdateContact> chatResponse) {
//        view.onUpdateContact(chatResponse);
//    }
//
//    @Override
//    public void onUploadFile(String content, ChatResponse<ResultFile> response) {
//        view.onUploadFile(response);
//    }
//
//
//    @Override
//    public void onUploadImageFile(String content, ChatResponse<ResultImageFile> chatResponse) {
//        view.onUploadImageFile(chatResponse);
//    }
//
//    @Override
//    public void onRemoveContact(String content, ChatResponse<ResultRemoveContact> response) {
//        view.onRemoveContact(response);
//    }
//
//    @Override
//    public void onThreadAddParticipant(String content, ChatResponse<ResultAddParticipant> outPutAddParticipant) {
//        view.onAddParticipant(outPutAddParticipant);
//    }
//
//    @Override
//    public void onThreadRemoveParticipant(String content, ChatResponse<ResultParticipant> chatResponse) {
//        view.onRemoveParticipant(chatResponse);
//    }
//
//
//    @Override
//    public void onDeleteMessage(String content, ChatResponse<ResultDeleteMessage> outPutDeleteMessage) {
//        view.onDeleteMessage(outPutDeleteMessage);
//    }
//
//    @Override
//    public void onThreadLeaveParticipant(String content, ChatResponse<ResultLeaveThread> response) {
//        view.onLeaveThread(response);
//    }
//
//    @Override
//    public void onChatState(ChatState state) {
//        view.onState(state);
//    }
//
//    @Override
//    public void onNewMessage(String content, ChatResponse<ResultNewMessage> chatResponse) {
//        Gson gson = new Gson();
//        OutPutNewMessage outPutNewMessage = gson.fromJson(content, OutPutNewMessage.class);
//        ResultNewMessage result = outPutNewMessage.getResult();
//        MessageVO messageVO = result.getMessageVO();
//        Participant participant = messageVO.getParticipant();
//        long id = messageVO.getId();
//        chat.seenMessage(id, participant.getId());
//        view.onNewMessage(chatResponse);
//    }
//
//    @Override
//    public void onBlock(String content, ChatResponse<ResultBlock> outPutBlock) {
//        view.onBlock(outPutBlock);
//    }
//
//    @Override
//    public void onUnBlock(String content, ChatResponse<ResultBlock> outPutBlock) {
//        view.onUnblock(outPutBlock);
//    }
//
//    @Override
//    public void onMapSearch(String content, OutPutMapNeshan outPutMapNeshan) {
//        view.onMapSearch();
//    }
//
//    @Override
//    public void onMapRouting(String content) {
//        view.onMapRouting();
//    }
//
//    @Override
//    public void onGetBlockList(String content, ChatResponse<ResultBlockList> outPutBlockList) {
//        view.onGetBlockList(outPutBlockList);
//    }
//
//    @Override
//    public void OnSeenMessageList(String content, ChatResponse<ResultParticipant> chatResponse) {
//        view.OnSeenMessageList(chatResponse);
//    }
//
//    @Override
//    public void onSearchContact(String content, ChatResponse<ResultContact> chatResponse) {
//        view.onSearchContact(chatResponse);
//    }
//
//    @Override
//    public void onError(String content, ErrorOutPut error) {
//        view.onError(error);
//    }
//
//    @Override
//    public void OnDeliveredMessageList(String content, ChatResponse<ResultParticipant> chatResponse) {
//        view.OnDeliveredMessageList(chatResponse);
//    }
//
//    @Override
//    public void OnSetRole(String content, ChatResponse<ResultSetRole> chatResponse) {
//        view.OnSetRole(chatResponse);
//    }
//
//    @Override
//    public void OnInteractMessage(String content, ChatResponse<ResultInteractMessage> chatResponse) {
//        view.OnInteractMessage(chatResponse);
//    }
//
//    @Override
//    public void OnRemoveRole(String content, ChatResponse<ResultSetRole> chatResponse) {
//        view.onRemoveRole(chatResponse);
//    }
//}
//
