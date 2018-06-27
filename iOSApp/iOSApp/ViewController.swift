//
//  ViewController.swift
//  iOSApp
//
//  Created by Alexandre Gherschon on 23/06/2018.
//  Copyright © 2018 galex.co.il. All rights reserved.
//

import UIKit


class ViewController: UIViewController {

    @IBOutlet weak var topLeftView: ChordView!
    @IBOutlet weak var topRightView: ChordView!
    @IBOutlet weak var bottomLeftView: ChordView!
    @IBOutlet weak var bottomRightView: ChordView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let test = KNFKotlinNativeFramework()
        test.helloFromKotlin()
    }
}
