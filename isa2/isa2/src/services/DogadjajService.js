import axios from 'axios';

const DOGADJAJ_API_BASE_URL = "http://localhost:8080/api/v1/dogadjaji";

class DogadjajService{

getDogadjaji(){
    return axios.get(DOGADJAJ_API_BASE_URL);
}
createDogadjaj(dogadjaj,type){
    return axios.post(DOGADJAJ_API_BASE_URL + '/' + type, dogadjaj);
}
getDogadjajById(dogadjajId){
    return axios.get(DOGADJAJ_API_BASE_URL + '/' + dogadjajId);
}
updateDogadjaj(dogadjaj,dogadjajId,type){
    return axios.put(DOGADJAJ_API_BASE_URL + '/' + type + '/' + dogadjajId,dogadjaj);
}
deleteDogadjaj(dogadjajId,type){
    return axios.delete(DOGADJAJ_API_BASE_URL+ '/' + type + '/' + dogadjajId);
}

}
export default new DogadjajService();