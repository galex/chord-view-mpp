//
//  ViewController.swift
//  iOSApp
//
//  Created by Alexandre Gherschon on 23/06/2018.
//  Copyright © 2018 galex.co.il. All rights reserved.
//

import UIKit


class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //let test = KNFKotlinNativeFramework()
        //test.helloFromKotlin()
        
        let frame1 = CGRect(x: view.frame.origin.x, y: view.frame.origin.y, width: view.frame.width / 2, height: view.frame.height / 2)
        view.addSubview(ChordView(frame: frame1, chord: KNFUkuleleChord.a))
        
        let frame2 = CGRect(x: view.frame.width / 2, y: view.frame.origin.y, width: view.frame.width / 2, height: view.frame.height / 2)
        view.addSubview(ChordView(frame: frame2, chord: KNFUkuleleChord.c))
        
        let frame3 = CGRect(x: view.frame.origin.x, y: view.frame.height / 2, width: view.frame.width / 2, height: view.frame.height / 2)
        view.addSubview(ChordView(frame: frame3, chord: KNFUkuleleChord.g))
        
        let frame4 = CGRect(x: view.frame.width / 2, y: view.frame.height / 2, width: view.frame.width / 2, height: view.frame.height / 2)
        view.addSubview(ChordView(frame: frame4, chord: KNFUkuleleChord.f))
        
    }
}
