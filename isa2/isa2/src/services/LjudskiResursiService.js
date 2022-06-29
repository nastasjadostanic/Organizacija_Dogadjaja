import axios from 'axios';

const LJUDSKIRESURSI_API_BASE_URL = "http://localhost:8080/api/v1/ljudskiResursi";

class LjudskiResursiService{

getLjudskiResursi(){
    return axios.get(LJUDSKIRESURSI_API_BASE_URL);
}
createLjudskiResurs(ljudskiresurs,type){
    return axios.post(LJUDSKIRESURSI_API_BASE_URL + '/' + type, ljudskiresurs);
}
getLjudskiResursiById(ljudskiresursId){
    return axios.get(LJUDSKIRESURSI_API_BASE_URL + '/' + ljudskiresursId);
}
updateLjudskiResurs(ljudskiresurs,ljudskiresursId,type){
    return axios.put(LJUDSKIRESURSI_API_BASE_URL + '/' + type + '/' + ljudskiresursId,ljudskiresurs);
}
deleteLjudskiResurs(ljudskiresursId,type){
    return axios.delete(LJUDSKIRESURSI_API_BASE_URL + '/' + type + '/' + ljudskiresursId);
}

getLjudskiResursiByDogadjajId(dogadjajId, type){
    return axios.get(LJUDSKIRESURSI_API_BASE_URL + '/dogadjaj/' +  type + '/' + dogadjajId);
}

}
export default new LjudskiResursiService();