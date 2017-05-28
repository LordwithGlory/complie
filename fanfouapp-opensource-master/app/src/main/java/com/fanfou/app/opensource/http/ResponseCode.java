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
package com.fanfou.app.opensource.http;

/**
 * @author mcxiaoke
 * @version 1.0 2011.05.02
 * @version 1.1 2011.05.05
 * @version 1.2 2011.05.17
 * @version 1.3 2011.10.28
 * @version 1.4 2011.11.21
 * @version 1.5 2011.12.13
 * 
 */
public interface ResponseCode {
    public static final int HTTP_OK = 200;// OK
    public static final int HTTP_BAD_REQUEST = 400;// Bad Request
    public static final int HTTP_UNAUTHORIZED = 401;// Not Authorized
    public static final int HTTP_FORBIDDEN = 403;// Forbidden
    public static final int HTTP_NOT_FOUND = 404;// Not Found
    public static final int HTTP_SERVER_ERROR = 500;// Internal Server

    public static final int ERROR_NORMAL = 0;
    public static final int ERROR_IO_EXCEPTION = -1;
    public static final int ERROR_NULL_TOKEN = -2;
    public static final int ERROR_AUTH_FAILED = -3;
    public static final int ERROR_AUTH_EMPTY = -4;
    public static final int ERROR_JSON_EXCEPTION = -5;
    public static final int ERROR_DUPLICATE = -6;

    // 200 OK: 成功
    // 202 Accepted: 发送消息时未提供source的请求会暂时放到队列中，并返回状态码202
    // 400 Bad Request： 无效的请求，返回值中可以看到错误的详细信息
    // 401 Unauthorized： 用户需要登录或者认证失败
    // 403 Forbidden： 用户无访问权限，例如访问了设置隐私的用户、消息等
    // 404 Not Found： 请求的资源已经不存在，例如访问了不存在的用户、消息等

}
