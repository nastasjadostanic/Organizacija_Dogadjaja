import axios from 'axios';

const OSTALIRESURSI_API_BASE_URL = "http://localhost:8080/api/v1/ostaliResursi";

class OstaliResursiService{

getOstaliResursi(){
    return axios.get(OSTALIRESURSI_API_BASE_URL);
}
createOstaliResurs(ostaliresurs,type){
    return axios.post(OSTALIRESURSI_API_BASE_URL + '/' + type, ostaliresurs);
}
getOstaliResursiById(ostaliresursId){
    return axios.get(OSTALIRESURSI_API_BASE_URL + '/' + ostaliresursId);
}
updateOstaliResurs(ostaliresurs,ostaliresursId,type){
    return axios.put(OSTALIRESURSI_API_BASE_URL + '/' + type + '/' + ostaliresursId,ostaliresurs);
}
deleteOstaliResurs(ostaliresursId,type){
    return axios.delete(OSTALIRESURSI_API_BASE_URL + '/' + type + '/' + ostaliresursId);
}

getOstaliResursiByDogadjajId(dogadjajId, type){
    return axios.get(OSTALIRESURSI_API_BASE_URL + '/dogadjaj/' +  type + '/' + dogadjajId);
}

}
export default new OstaliResursiService();