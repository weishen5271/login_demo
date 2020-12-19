/*
設備設施
 */

import request from '@/utils/request';

export  const QUERY_DEVICEINFO_LIST = params => request.get("/device/queryList",{params})

export const QUERY_DEVICEINFO_PAGE = params => request.get("/device/queryPage",{params})

export const INSERT_DEVICEINFO = params => request.post("/device/insert",params)

export const DELETE_DEVICEINFO = params => request.post("/device/deleteByEventIdList", params)

export const UPDATE_DEVICEINFO = params => request.post("/device/update", params)

export const QUERY_DEVICEINFO_EVENTID = params => request.get("/device/queryByEventId",{params})
