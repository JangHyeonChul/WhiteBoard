export function postForm(url, formData) {
    return fetch(url, {
        method: 'POST',
        body: formData,
    }).then((response) => response.json());
}

export function getJson(url) {
    return fetch(url).then((response) => response.json());
}