package ksb2_hwork3_KoronaGorPolskich;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kpg")
public class KoronaPolskichGorApi {

    private List<KoronaPolskichGor> koronaPolskichGorList;




    public KoronaPolskichGorApi() {
        this.koronaPolskichGorList = new ArrayList<>();
        koronaPolskichGorList.add(new KoronaPolskichGor(1, "Góry Świętokrzyskie",	"ŁYSICA",	612));
        koronaPolskichGorList.add(new KoronaPolskichGor(2,	"Masyw Ślęży (Przedgórze Sudeckie)",	"ŚLĘŻA",	718));
        koronaPolskichGorList.add(new KoronaPolskichGor(3,	"Góry Kaczawskie",	"SKOPIEC",	724));
        koronaPolskichGorList.add(new KoronaPolskichGor(4,	"Góry Bardzkie",	"KŁODZKA GÓRA",	765));
        koronaPolskichGorList.add((new KoronaPolskichGor(5,	"Góry Wałbrzyskie",	"CHEŁMIEC",	869)));
        koronaPolskichGorList.add((new KoronaPolskichGor(6,	"Góry Opawskie",	"BISKUPIA KOPA",	889)));
        koronaPolskichGorList.add((new KoronaPolskichGor(7,	"Beskid Makowski",	"LUBOMIR",	912)));
        koronaPolskichGorList.add((new KoronaPolskichGor(8,	"Góry Stołowe",	"SZCZELINIEC WIELKI", 919)));
    }

    // todo List using STREAM
    List<KoronaPolskichGor> getList(){
        return new ArrayList<>(koronaPolskichGorList);
    }

    @GetMapping
    public ResponseEntity<List<KoronaPolskichGor>> getMountains() {
        return new ResponseEntity<>(koronaPolskichGorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KoronaPolskichGor> getMountainsById(@PathVariable int id) {
        Optional<KoronaPolskichGor> first = koronaPolskichGorList.stream().filter(koronaPolskichGor -> koronaPolskichGor.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity addMountain(@RequestBody KoronaPolskichGor koronaPolskichGor) {
        boolean add = koronaPolskichGorList.add(koronaPolskichGor);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity modMountain(@RequestBody KoronaPolskichGor newKoronaPolskichGor) {
        Optional<KoronaPolskichGor> first = koronaPolskichGorList.stream().filter(koronaPolskichGor -> koronaPolskichGor.getId() == newKoronaPolskichGor.getId()).findFirst();
        if (first.isPresent()) {
            koronaPolskichGorList.remove(first.get());
            koronaPolskichGorList.add(newKoronaPolskichGor);

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeKoronaPolskichGor(@PathVariable int id) {
        Optional<KoronaPolskichGor> first = koronaPolskichGorList.stream().filter(koronaPolskichGor -> koronaPolskichGor.getId() == id).findFirst();
        if (first.isPresent()) {
            koronaPolskichGorList.remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}