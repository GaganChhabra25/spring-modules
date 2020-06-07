import axios from "axios";

class ApiService {
    constructor(baseUrl) {
        this.baseUrl = baseUrl;
    }

    resolve(inputUrl) {
        return this.baseUrl + inputUrl;
    }

    get(inputUrl) {
        const url = this.resolve(inputUrl);
        return fetch(url).then((response) => {
            if(!response.ok) {
                return Promise.reject(response);
            }
            if (response.status === 204) {
                return {};
            }
            return response.json();
        })
    }

    post(inputUrl, requestBody) {
        const url = this.resolve(inputUrl);
        return fetch(url, {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(requestBody)
        })
            .then((response) => {
                if (!response.ok) {
                    return Promise.reject(response);
                }
                return response.text().then((text) => {
                    return text ? JSON.parse(text) : {};
                });
            });
    }

    put(inputUrl, requestBody) {
        const url = this.resolve(inputUrl);
        return fetch(url, {
            method: 'put',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(requestBody)
        }).then((response) => {
            if (!response.ok) {
                return Promise.reject(response);
            }
            return response.text().then((text) => {
                return text ? JSON.parse(text) : {};
            });
        });
    }

    delete(inputUrl, requestBody) {
        const url = this.resolve(inputUrl);
        return fetch(url, {
            method: 'delete',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(requestBody)
        }).then((response) => {
            if (!response.ok) {
                return Promise.reject(response);
            }
            return response.text().then((text) => {
                return text ? JSON.parse(text) : {};
            });
        });
    }
}



export default ApiService;