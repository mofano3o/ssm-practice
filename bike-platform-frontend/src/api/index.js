import request from '../utils/request';

export const fetchData = query => {
    return request({
        url: './table.json',
        method: 'get',
        params: query
    });
};

export const get = (url, params) => {
    return request({
        url: url,
        method: 'get',
        params: params
    })
}

export const post = (url, payload, config = {}) => {
    return request.post(url, payload, config)
}

export const put = (url, payload) => {
    return request.put(url, payload)
}

export const del = (url) => {
    return request.delete(url)
}
