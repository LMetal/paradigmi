# -*- coding: utf-8 -*-



#%%
# Scrivi una funzione che trova una lista di parole in una matrice di lettere
# La matrice di lettere viene letta dal file di testo "WordSquare.txt"x.    
# La parola puo' essere orizzontale o verticale e puo' essere
# in un qualsiasi orientamento (sinistra=> destra, destra=>sinistra,
# alto=>basso, basso => alto)
#
# La funzione ritorna un dizionario con chiave le parole da cercare
# se la parola c'e', viene associata alla coppia di indici di inizio e
# fine della parola nella matrice, se non c'e' viene associata a -1.    

# 1)  Prima scrivere una funzione: leggiFile(direct,nomeFile)
# che prende in input il nome della directory e quello del file nelle 
# directory in cui si trovano le stringhe che rappresentano le righe
# della matrice di lettere e ritorna la lista di tali stringhe 
    

# baseDir= "..."

# leggiFile(baseDir,'WordSquare.txt')

# leggi riga per riga eliminando gli  spazi bianchi a destra 

# 2) Poi scrivere una funzione cercaInRighe(parola,righe) che prende in input 
# una parola e una lista di stringhe (le righe della matrice di lettere) 
# e cerca la parola nelle stringhe sia da sinistra a destra che 
# da destra a sinistra e ritorna gli indici di inizio e fine della parola
# e -1 se non la trova

# usate enumerate per associare a ogni riga il suo indice e
# il metodo find delle stringhe per cercare la parola in
# una riga
# per cercare da destra a sinistra rovesciate la stringa


# 3)  Usare la funzione precedente per definire una funzione
# cercaInColonne(parola,righe) per cercare nelle colonne della matrice
# di lettere come la precedente la parola puo' essere dall'alto in basso
# o dal basso in alto e come la precedente ritorna le coordinate di inizio
# e fine oppure -1.    

# cercate di ottenere le colonne dalle righe usando zip e join
 
# 4) Usare le 2 funzioni precedenti per definire la funzione 
# cercaParole (parole, righe) => dizionario con chiavi le stringhe in parole
# e valore -1 o gli indici di inizio e fine della parole    
    
    

# Questa e' la lista delle parole:      
      
parole =['angelico','ariosto','baviera', 'camilleri','cassino','corsica',
           'fenoglio','maglia','notaio','olandesi','pacifico',
          'palomar','parise','roncalli','sciascia','serao']


# leggiFile(baseDir,'WordSquare.txt') dovrebbe ritornare

matrix = ['olandesirap',
 'iiseraoimaa',
 'angelicosio',
 'tnvghrrcrtc',
 'oaacaeaeoai',
 'nrroilgonef',
 'ieirolagcei',
 'siosaiavaec',
 'svsirmaglia',
 'aatcramolap',
 'cboaicsaics',
]


def leggiFile():
    #with open('WordSquare.txt','r') as myFile:
    #    print(2)
    return matrix

def righeColonne(matrix):
    list1 = list(zip(*matrix))
    return [ ''.join(x) for x in list1 ]

def createMatrix():
    m1 = leggiFile()
    m2 = righeColonne(m1)
    return m1, m2

def createDict(parole):
    d = {}
    for parola in parole:
        d[ parola ] = [-1, -1]
    return d

def cercaInRighe(parola, righe):
    i=0
    for riga in righe:
        indice = riga.find(parola)
        if indice != -1:
            return [indice, i-1]
        i=i+1

def matrixSolve():
    matrix_righe, matrix_colonne = createMatrix()
    dizionario = createDict(parole)
    for parola in parole:
        dizionario[parola] = cercaInRighe(parola,matrix_righe)
    print(dizionario)

matrixSolve()
