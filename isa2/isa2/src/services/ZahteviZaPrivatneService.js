import axios from 'axios';

const ZAHTEVPRIVATAN_API_BASE_URL = "http://localhost:8080/api/v1/zahteviPrivatanDogadjaj";

class ZahtevZaPrivatneService{

getZahtevi(){
    return axios.get(ZAHTEVPRIVATAN_API_BASE_URL);
}
createZahtev(zahtev,type){
    return axios.post(ZAHTEVPRIVATAN_API_BASE_URL + '/' + type, zahtev);
}
getZahtevById(zahtevId){
    return axios.get(ZAHTEVPRIVATAN_API_BASE_URL + '/' + zahtevId);
}
updateDogadjaj(zahtev,zahtevId,type){
    return axios.put(ZAHTEVPRIVATAN_API_BASE_URL + '/' + type + '/' + zahtevId,zahtev);
}
deleteZahtev(zahtevId,type){
    return axios.delete(ZAHTEVPRIVATAN_API_BASE_URL+ '/' + type + '/' + zahtevId);
}

}
export default new ZahtevZaPrivatneService();