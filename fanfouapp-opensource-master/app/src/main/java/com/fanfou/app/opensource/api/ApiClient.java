/*******************************************************************************
 * Copyright 2011, 2012, 2013 fanfou.com, Xiaoke, Zhang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.fanfou.app.opensource.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.fanfou.app.opensource.api.bean.DirectMessage;
import com.fanfou.app.opensource.api.bean.Search;
import com.fanfou.app.opensource.api.bean.Status;
import com.fanfou.app.opensource.api.bean.User;

/**
 * @author mcxiaoke
 * @version 1.0 2011.05.12
 * @version 1.1 2011.05.15
 * @version 1.2 2011.10.18
 * @version 1.3 2011.10.28
 * @version 1.4 2011.11.07
 * @version 1.5 2011.11.09
 * @version 1.6 2011.11.11
 * @version 2.0 2011.11.18
 * @version 3.0 2011.11.21
 * 
 */
public interface ApiClient {

    /**
     * fetch user list blocked by me
     * 
     * @return
     * @throws ApiException
     */
    ArrayList<User> blocksBlocking(int count, int page, String mode)
            throws ApiException;

    /**
     * action: block
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    User blocksCreate(String userId, String mode) throws ApiException;

    /**
     * action: unblock
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    User blocksDelete(String userId, String mode) throws ApiException;

    /**
     * check user is or not blocked.
     * 
     * @param userId
     *            target user id
     * @return
     * @throws ApiException
     */
    User blocksExists(String userId, String mode) throws ApiException;

    /**
     * fetch user ids list blocked by me
     * 
     * @return
     * @throws ApiException
     */
    ArrayList<String> blocksIDs() throws ApiException;

    /**
     * msg context timeline
     * 
     * @param id
     *            status id
     * @param isHtml
     * @return
     * @throws ApiException
     */
    ArrayList<Status> contextTimeline(String id, String format, String mode)
            throws ApiException;

    ArrayList<DirectMessage> directMessagesConversation(String userId,
            String maxId, int count, String mode) throws ApiException;

    ArrayList<DirectMessage> directMessagesConversationList(int count,
            int page, String mode) throws ApiException;

    /**
     * send a dm
     * 
     * @param userId
     * @param text
     * @param inReplyToId
     * @return
     * @throws ApiException
     */
    DirectMessage directMessagesCreate(String userId, String text,
            String inReplyToId, String mode) throws ApiException;

    /**
     * delete a dm
     * 
     * @param directMessageId
     * @return
     * @throws ApiException
     */
    DirectMessage directMessagesDelete(String directMessageId, String mode)
            throws ApiException;

    /**
     * inbox messages
     * 
     * @param count
     * @param page
     * @param sinceId
     * @param maxId
     * @return
     * @throws ApiException
     */
    ArrayList<DirectMessage> directMessagesInbox(int count, int page,
            String sinceId, String maxId, String mode) throws ApiException;

    /**
     * outbox messages
     * 
     * @param count
     * @param page
     * @param sinceId
     * @param maxId
     * @return
     * @throws ApiException
     */
    ArrayList<DirectMessage> directMessagesOutbox(int count, int page,
            String sinceId, String maxId, String mode) throws ApiException;

    /**
     * favorites
     * 
     * @param count
     * @param page
     * @param userId
     * @return
     * @throws ApiException
     */
    ArrayList<Status> favorites(int count, int page, String userId,
            String format, String mode) throws ApiException;

    /**
     * action: favorite
     * 
     * @param statusId
     * @return
     * @throws ApiException
     */
    Status favoritesCreate(String statusId, String format, String mode)
            throws ApiException;

    /**
     * action: unfavorite
     * 
     * @param statusId
     * @return
     * @throws ApiException
     */
    Status favoritesDelete(String statusId, String format, String mode)
            throws ApiException;

    /**
     * followers id list
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    ArrayList<String> followersIDs(String userId, int count, int page)
            throws ApiException;

    /**
     * action: follow
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    User friendshipsCreate(String userId, String mode) throws ApiException;

    /**
     * action: unfollow
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    User friendshipsDelete(String userId, String mode) throws ApiException;

    /**
     * check two users is or not friends, check a is or not follow b.
     * 
     * @param userA
     * @param userB
     * @return
     * @throws ApiException
     */
    boolean friendshipsExists(String userA, String userB) throws ApiException;

    /**
     * friends id list
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    ArrayList<String> friendsIDs(String userId, int count, int page)
            throws ApiException;

    Context getAppContext();

    // friends timeline
    /**
     * home timeline
     * 
     * @param count
     * @param page
     * @param userId
     * @param sinceId
     * @param maxId
     * @return
     * @throws ApiException
     */
    ArrayList<Status> homeTimeline(int count, int page, String sinceId,
            String maxId, String format, String mode) throws ApiException;

    // mention timeline
    /**
     * mentions
     * 
     * @param count
     * @param page
     * @param userId
     * @param sinceId
     * @param maxId
     * @return
     * @throws ApiException
     */
    ArrayList<Status> mentions(int count, int page, String sinceId,
            String maxId, String format, String mode) throws ApiException;

    /**
     * user timeline contains photos
     * 
     * @param count
     * @param page
     * @param userId
     * @param sinceId
     * @param maxId
     * @param isHtml
     * @return
     * @throws ApiException
     */
    ArrayList<Status> photosTimeline(int count, int page, String userId,
            String sinceId, String maxId, String format, String mode)
            throws ApiException;

    /**
     * upload a photo
     * 
     * @param photo
     * @param status
     * @param source
     * @param location
     * @return
     * @throws ApiException
     */
    Status photosUpload(File photo, String status, String source,
            String location, String format, String mode) throws ApiException;

    // public timeline
    // count -- status count
    /**
     * public timeline
     * 
     * @param count
     * @return
     * @throws ApiException
     */
    ArrayList<Status> pubicTimeline(int count, String format, String mode)
            throws ApiException;

    // replies timeline
    /**
     * replies
     * 
     * @param count
     * @param page
     * @param userId
     * @param sinceId
     * @param maxId
     * @return
     * @throws ApiException
     */
    ArrayList<Status> replies(int count, int page, String userId,
            String sinceId, String maxId, String format, String mode)
            throws ApiException;

    /**
     * add a saved search
     * 
     * @param name
     * @return
     * @throws ApiException
     */
    Search savedSearchesCreate(String name) throws ApiException;

    /**
     * delete a saved search
     * 
     * @param id
     * @return
     * @throws ApiException
     */
    Search savedSearchesDelete(int id) throws ApiException;

    /**
     * get saved searches
     * 
     * @return
     * @throws ApiException
     */
    ArrayList<Search> savedSearchesList() throws ApiException;

    /**
     * show a saved search
     * 
     * @param id
     * @return
     * @throws ApiException
     */
    Search savedSearchesShow(int id) throws ApiException;

    /**
     * search public timeline
     * 
     * @param keyword
     * @param maxId
     * @return
     * @throws ApiException
     */
    ArrayList<Status> search(String keyword, String sinceId, String maxId,
            int count, String format, String mode) throws ApiException;

    /**
     * search users
     * 
     * @param keyword
     * @param count
     * @param page
     * @param mode
     * @return
     * @throws ApiException
     */
    ArrayList<User> searchUsers(String keyword, int count, int page, String mode)
            throws ApiException;

    /**
     * update a status
     * 
     * @param status
     * @param inReplyToStatusId
     * @param source
     * @param location
     * @param repostStatusId
     * @return
     * @throws ApiException
     */
    Status statusesCreate(String status, String inReplyToStatusId,
            String source, String location, String repostStatusId,
            String format, String mode) throws ApiException;

    /**
     * delete a status
     * 
     * @param statusId
     * @return
     * @throws ApiException
     */
    Status statusesDelete(String statusId, String format, String mode)
            throws ApiException;

    /**
     * show a status details
     * 
     * @param statusId
     * @return
     * @throws ApiException
     */
    Status statusesShow(String statusId, String format, String mode)
            throws ApiException;

    /**
     * get trends
     * 
     * @return
     * @throws ApiException
     */
    ArrayList<Search> trends() throws ApiException;

    /**
     * update user profile
     * 
     * @param description
     * @param name
     *            realname
     * @param location
     * @param url
     * @param email
     *            account email, not recommand.
     * @return
     * @throws ApiException
     */
    User updateProfile(String description, String name, String location,
            String url, String mode) throws ApiException;

    /**
     * udpate user profile image
     * 
     * @param image
     *            image file
     * @return
     * @throws ApiException
     */
    User updateProfileImage(File image, String mode) throws ApiException;

    /**
     * followers info list
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    List<User> usersFollowers(String userId, int count, int page, String mode)
            throws ApiException;

    /**
     * friends info list
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    ArrayList<User> usersFriends(String userId, int count, int page, String mode)
            throws ApiException;

    /**
     * show a user's profile
     * 
     * @param userId
     * @return
     * @throws ApiException
     */
    User userShow(String userId, String mode) throws ApiException;

    // user timeline
    /**
     * user timeline
     * 
     * @param count
     * @param page
     * @param userId
     * @param sinceId
     * @param maxId
     * @return
     * @throws ApiException
     */
    ArrayList<Status> userTimeline(int count, int page, String userId,
            String sinceId, String maxId, String format, String mode)
            throws ApiException;

    // account verify
    // for basic auth key is username, value is password
    // for oauth key is accessToken, value is accessTokenSecret
    /**
     * verify account
     * 
     * @param key
     * @param value
     * @return
     * @throws ApiException
     */
    User verifyAccount(String mode) throws ApiException;

}
