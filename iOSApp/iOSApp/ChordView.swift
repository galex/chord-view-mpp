//
// Created by Alexandre Gherschon on 26/06/2018.
// Copyright (c) 2018 galex.co.il. All rights reserved.
//

import Foundation
import UIKit
import KotlinNativeFramework

class ChordView: UIView {

    @IBOutlet var view: UIView!
    
    var ukuleleChord: KNFUkuleleChord?
    private var linesLayer: CAShapeLayer?
    private var dotsLayers = [CAShapeLayer]()
    private var numLines = 0
    private var numCircles = 0
    
    convenience init(frame: CGRect, chord: KNFUkuleleChord) {
        self.init(frame: frame)
        
        ukuleleChord = chord
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        commonInit()
        
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        
        commonInit()
    }
    
    func commonInit() {
        Bundle.main.loadNibNamed("ChordView", owner: self, options: nil)
        addSubview(view)
        view.frame = self.bounds
        view.autoresizingMask = [.flexibleHeight, .flexibleWidth]
    }
    
    override func draw(_ rect: CGRect) {
        super.draw(rect)
        NSLog("draw. frame is \(frame)")

        if linesLayer == nil {
            linesLayer = CAShapeLayer()
            view.layer.addSublayer(linesLayer!)
        }
        
        for layer in dotsLayers {
            layer.removeFromSuperlayer()
        }
        
        dotsLayers.removeAll()
        
        var linesCount = 0
        var circlesIndex = 0
        let aPath = UIBezierPath()
        
        let helper = KNFChordViewHelper()
        helper.drawGrid(viewWidth: Float(frame.width), currentHeight: Float(frame.height), renderLine: { (x, y, endX, endY) in
            NSLog("drawing line from \(x),\(y) to \(endX),\(endY)")
            
            aPath.move(to: CGPoint(x: CGFloat(truncating: x), y: CGFloat(truncating: y)))
            aPath.addLine(to: CGPoint(x: CGFloat(truncating: endX), y: CGFloat(truncating: endY)))
            
            linesCount += 1
            
            if linesCount == self.numLines {
                NSLog("drawing liones")
                self.linesLayer?.path = aPath.cgPath
                self.linesLayer?.strokeColor = UIColor.black.cgColor
                self.linesLayer?.lineWidth = 5
            }
            
            return KNFStdlibUnit()
        }, beforeRender: { numLines in
            self.numLines = Int(truncating: numLines)
            return KNFStdlibUnit()
        }, afterRender: {
            // do nothing
            return KNFStdlibUnit()
        })
        
        helper.drawPositions(viewWidth: Float(frame.width), currentHeight: Float(frame.height), ukuleleChord: ukuleleChord!, renderCircle: { (x, y) in
            NSLog("drawing dot at \(x),\(y)")
            
            let circlePath = UIBezierPath(arcCenter: CGPoint(x: CGFloat(truncating: x), y: CGFloat(truncating: y)), radius: 10, startAngle: CGFloat(0), endAngle:CGFloat(Double.pi * 2), clockwise: true)
            
            let layer = self.dotsLayers[circlesIndex]
            
            layer.path = circlePath.cgPath
            layer.fillColor = UIColor.black.cgColor
            
            self.view.layer.addSublayer(layer)
            
            circlesIndex += 1
            
            return KNFStdlibUnit()
        }, beforeRender: { numDots in
            self.numCircles = Int(truncating: numDots)
            for _ in 0...Int(truncating: numDots) {
                self.dotsLayers.append(CAShapeLayer())
            }
            return KNFStdlibUnit()
        }, afterRender: {
            // do nothing
            return KNFStdlibUnit()
        })
        
    }
}
