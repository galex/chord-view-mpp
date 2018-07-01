//
// Created by Alexandre Gherschon on 26/06/2018.
// Copyright (c) 2018 galex.co.il. All rights reserved.
//

import Foundation
import UIKit

class ChordView: UIView {

    let ukuleleChord: KNFUkuleleChord? = nil
    
    override func draw(_ rect: CGRect) {
        super.draw(rect)
        
        if let context = UIGraphicsGetCurrentContext() {
            
            KNFChordViewHelper().drawGrid(viewWidth: Float(frame.width), currentHeight: Float(frame.height), renderLine: { (x: NSNumber, y: NSNumber, endX: NSNumber, endY: NSNumber) in
                
                context.setStrokeColor(UIColor.gray.cgColor)
                context.setLineWidth(1)
                context.move(to: CGPoint(x: 0, y: self.bounds.height))
                context.addLine(to: CGPoint(x: self.bounds.width, y: self.bounds.height))
                context.strokePath()
                return KNFStdlibUnit()
            })
        }
    }
}
