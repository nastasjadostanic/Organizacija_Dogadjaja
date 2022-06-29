import axios from 'axios';

const SALA_API_BASE_URL = "http://localhost:8080/api/v1/sale";

class SalaService{

getSale(){
    return axios.get( SALA_API_BASE_URL);
}
createSala(sala){
    return axios.post(SALA_API_BASE_URL, sala);
}
getSalaById(salaId){
    return axios.get(SALA_API_BASE_URL + '/' + salaId);
}
updateSala(sala,salaId){
    return axios.put(SALA_API_BASE_URL + '/' + salaId, sala);
}
deleteSala(salaId){
    return axios.delete(SALA_API_BASE_URL + '/' + salaId);
}
}
export default new SalaService();
